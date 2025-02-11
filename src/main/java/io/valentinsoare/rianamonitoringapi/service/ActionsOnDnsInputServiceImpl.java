package io.valentinsoare.rianamonitoringapi.service;

import io.valentinsoare.rianamonitoringapi.util.QueryCache;
import io.valentinsoare.rianamonitoringapi.config.MonitoringDefaultValues;
import io.valentinsoare.rianamonitoringapi.dto.ExternalDnsAnswer;
import io.valentinsoare.rianamonitoringapi.dto.GoogleDnsResponse;
import io.valentinsoare.rianamonitoringapi.dto.ZonesWithSOAAndNSGroupValues;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class ActionsOnDnsInputServiceImpl implements ActionsOnDnsInputService {
    private final QueryCache queryCache;
    private final DnsQueryService dnsQueryService;
    private final InputOptionsAsArgumentsService inputOptionsAsArgumentsService;

    @Autowired
    public ActionsOnDnsInputServiceImpl(QueryCache queryCache,
                                        DnsQueryService dnsQueryService,
                                        InputOptionsAsArgumentsService inputOptionsAsArgumentsService) {
        this.queryCache = queryCache;
        this.dnsQueryService = dnsQueryService;
        this.inputOptionsAsArgumentsService = new InputOptionsAsArgumentsServiceImpl();
    }

    @Override
    public void startComparisonOfSoaValues() {
        Mono<ZonesWithSOAAndNSGroupValues> publicSoaValuesFromInfoBlox = dnsQueryService.getAllZonesWithValuesFromInternal(Integer.parseInt(MonitoringDefaultValues.maxResults),Integer.parseInt(MonitoringDefaultValues.paging),
                                    Integer.parseInt(MonitoringDefaultValues.returnAsObject), MonitoringDefaultValues.returnFields,null,null)
                                .flatMap(dnsQueryService::extractPublicZonesFromInternalInput);

        Mono<GoogleDnsResponse> soaValuesFromGoogleResolver = publicSoaValuesFromInfoBlox.flatMap(dnsQueryService::getAllZonesWithValuesFromExternal);

        publicSoaValuesFromInfoBlox.subscribe(soaValuesFromInfoBloxResponse -> {
            soaValuesFromGoogleResolver.subscribe(soaValuesFromGoogleResolverResponse -> {
                checkStartOfAuthorityValues(soaValuesFromInfoBloxResponse, soaValuesFromGoogleResolverResponse);
            });
        });
    }

    @Override
    public void checkStartOfAuthorityValues(ZonesWithSOAAndNSGroupValues soaValuesFromInfoBlox, GoogleDnsResponse soaValuesFromGoogleResolver) {
        Flux.fromIterable(soaValuesFromInfoBlox.getResult())
                .parallel()
                .runOn(Schedulers.parallel())
                .flatMap(soaValueInfoBlox -> Flux.fromIterable(soaValuesFromGoogleResolver.getAnswer())
                        .filter(soaValueGoogle -> soaValueInfoBlox.getFqdn().equals(soaValueGoogle.getName()))
                        .doOnNext(soaValueGoogle -> {
                            String soaValueFromInfoBlox = String.valueOf(soaValueInfoBlox.getSoaSerialNumber());

                            if (!soaValueFromInfoBlox.equals(soaValueGoogle.getData())) {
                                log.error("The SOA value for the zone {} is different in InfoBlox and Google DNS. InfoBlox: {}, Google DNS: {}",
                                        soaValueInfoBlox.getFqdn(), soaValueFromInfoBlox, soaValueGoogle.getData());
                            }
                        })
                        .then())
                .sequential()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe();
    }

    @Override
    public void checkNameServerValues() {
        Flux.from(dnsQueryService.getIPAddressForNameservers())
                .subscribe(this::checkNameserverIPAddresses);
    }

    @Override
    public void checkNameserverIPAddresses(ExternalDnsAnswer externalDnsAnswer) {
        AtomicReference<String> ipAddressValueInCache = new AtomicReference<>();

        Mono.just(externalDnsAnswer)
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(answer -> {
                    String fqdn = answer.getName();
                    String currentIpAddress = answer.getData();

                    ipAddressValueInCache.set(queryCache.getNameserverCache(fqdn));

                    if (ipAddressValueInCache.get() == null) {
                        queryCache.putNameserverCache(fqdn, currentIpAddress);
                    } else if (!ipAddressValueInCache.get().equals(currentIpAddress)) {
                        log.error("The IP address for the nameserver {} has changed from {} to {}.", fqdn, ipAddressValueInCache.get(), currentIpAddress);
                    }
                });
    }

    @Override
    public void runTasksFromInput(String[] arguments, InputStream inputStream) {
        List<String> typeOfTasks = inputOptionsAsArgumentsService.extractTypeOfTasks(arguments);
    }

    @Override
    public void executeTasks(List<String> options) {

    }
}
