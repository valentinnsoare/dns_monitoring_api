package io.valentinsoare.rianamonitoringapi.service;

import io.valentinsoare.rianamonitoringapi.config.MonitoringDefaultValues;
import io.valentinsoare.rianamonitoringapi.util.QueryCache;
import io.valentinsoare.rianamonitoringapi.config.OracleCloudProperties;
import io.valentinsoare.rianamonitoringapi.config.WebClientConfigGoogle;
import io.valentinsoare.rianamonitoringapi.config.WebClientConfigInfoBlox;
import io.valentinsoare.rianamonitoringapi.dto.ExternalDnsAnswer;
import io.valentinsoare.rianamonitoringapi.dto.GoogleDnsResponse;
import io.valentinsoare.rianamonitoringapi.dto.ZoneSoaRequest;
import io.valentinsoare.rianamonitoringapi.dto.ZonesWithSOAAndNSGroupValues;
import io.valentinsoare.rianamonitoringapi.util.RetryUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Getter
@Setter
@Service
public class DnsQueryServiceImpl implements DnsQueryService {
    private final WebClientConfigGoogle webClientConfigGoogle;
    private final WebClientConfigInfoBlox webClientConfigInfoBlox;
    private final QueryCache queryCache;

    private OracleCloudProperties oracleCloudProperties;

    @Autowired
    public DnsQueryServiceImpl(QueryCache queryCache,
                               WebClientConfigGoogle webClientConfig,
                               WebClientConfigInfoBlox webClientConfigInfoBlox,
                               OracleCloudProperties oracleCloudProperties) {
        this.queryCache = queryCache;
        this.webClientConfigGoogle = webClientConfig;
        this.webClientConfigInfoBlox = webClientConfigInfoBlox;
        this.oracleCloudProperties = oracleCloudProperties;
    }

    private String generateCacheKey(int maxResults, int paging, int returnAsObject, String returnFields, String fqdn, String nextPageId) {
        return String.format("%d|%d|%d|%s|%s|%s", maxResults, paging, returnAsObject, returnFields, fqdn, nextPageId);
    }

    @Override
    public Mono<GoogleDnsResponse> getAllZonesWithValuesFromExternal(ZonesWithSOAAndNSGroupValues publicZones) {
        return  Flux.fromIterable(publicZones.getResult())
                .parallel()
                .runOn(Schedulers.parallel())
                .flatMap(zone -> getSOARecordFromPublic(zone.getFqdn()),
                        true, MonitoringDefaultValues.maxConcurrencyLimit)
                .sequential()
                .collectList()
                .map(e -> GoogleDnsResponse.builder()
                        .nextPageId(publicZones.getNext_page_id())
                        .answer(e)
                        .build())
                .subscribeOn(Schedulers.boundedElastic());
        
    }

    @Override
    public Mono<ExternalDnsAnswer> getSOARecordFromPublic(String zone) {
        return webClientConfigGoogle.getWebClientForGoogle().get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("name", zone)
                        .queryParam("type", "SOA")
                        .build())
                .retrieve()
                .bodyToMono(GoogleDnsResponse.class)
                .retryWhen(RetryUtil.retrySpec(3, 1000))
                .flatMap(e -> Mono.justOrEmpty(Optional.ofNullable(e.getAnswer()).map(List::getFirst)))
                        .onErrorContinue((throwable, o) -> log.error("Error while fetching SOA record: {}", throwable.getMessage()))
                        .map(answer -> ExternalDnsAnswer.builder()
                                .name(answer.getName())
                                .type(answer.getType())
                                .TTL(answer.getTTL())
                                .data(answer.getData().split(" ").length > 2 ? answer.getData().split(" ")[2] : "")
                                .build()
                        );

    }

    @Override
    public Flux<ExternalDnsAnswer> getIPAddressForNameservers() {
        return Flux.fromIterable(oracleCloudProperties.getNameservers())
                .flatMap(ns -> webClientConfigGoogle.getWebClientForGoogle().get()
                        .uri(uriBuilder -> uriBuilder
                                .queryParam("name", ns)
                                .queryParam("type", "A")
                                .build())
                        .retrieve()
                        .bodyToMono(GoogleDnsResponse.class)
                        .retryWhen(RetryUtil.retrySpec(3, 1000))
                        .flatMapMany(e -> Flux.fromIterable(e.getAnswer()))
                        .map(answer -> ExternalDnsAnswer.builder()
                                .name(answer.getName())
                                .type(answer.getType())
                                .TTL(answer.getTTL())
                                .data(answer.getData())
                                .build())
                        .subscribeOn(Schedulers.boundedElastic())
                );
    }

    @Override
    public Mono<ZonesWithSOAAndNSGroupValues> extractPublicZonesFromInternalInput(ZonesWithSOAAndNSGroupValues zones) {
        List<ZoneSoaRequest> publicZones = new CopyOnWriteArrayList<>();

       return Flux.fromIterable(zones.getResult())
                .filter(item -> !item.getNsGroup().equalsIgnoreCase("internal_dns"))
                .onErrorContinue((throwable, o) -> log.error("Error while extracting public zones: {}", throwable.getMessage()))
                .parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(publicZones::add)
                .sequential()
                .then(Mono.just(ZonesWithSOAAndNSGroupValues.builder()
                        .next_page_id(zones.getNext_page_id())
                        .result(publicZones)
                        .build()))
               .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<ZonesWithSOAAndNSGroupValues> getAllZonesWithValuesFromInternal(int maxResults, int paging, int returnAsObject,
                                                                                String returnFields, String fqdn, String nextPageId) {
        String cacheKey = generateCacheKey(maxResults, paging, returnAsObject, returnFields, fqdn, nextPageId);

        TreeMap<String, Object> queryParams = queryCache.getOrCreate(cacheKey, key -> {
            TreeMap<String, Object> params = new TreeMap<>(Map.of(
                    "_max_results", maxResults,
                    "_return_as_object", returnAsObject,
                    "_paging", paging,
                    "_return_fields", returnFields
            ));

            if (fqdn != null) {
                params.put("fqdn~", fqdn);
            }

            if (nextPageId != null) {
                params.put("_page_id", nextPageId);
            }

            return params;
        });

        try {
            return webClientConfigInfoBlox.getWebClientForInfoBlox().get()
                    .uri(uriBuilder -> {
                        UriBuilder builder = uriBuilder.path("/zone_auth");
                        queryParams.forEach(builder::queryParam);
                        return builder.build();
                    })
                    .retrieve()
                    .bodyToMono(ZonesWithSOAAndNSGroupValues.class)
                    .retryWhen(RetryUtil.retrySpec(3, 1000))
                    .subscribeOn(Schedulers.boundedElastic());
        } catch (WebClientResponseException e) {
            log.error("Error while fetching zones with SOA values: {}", e.getResponseBodyAsString());
        }

        return Mono.empty();
    }
}
