package io.valentinsoare.rianamonitoringapi.service;

import io.valentinsoare.rianamonitoringapi.dto.ExternalDnsAnswer;
import io.valentinsoare.rianamonitoringapi.dto.GoogleDnsResponse;
import io.valentinsoare.rianamonitoringapi.dto.ZonesWithSOAAndNSGroupValues;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DnsQueryService {
    Mono<ZonesWithSOAAndNSGroupValues> getAllZonesWithValuesFromInternal(int resultsPerPage, int paging, int returnAsObject, String returnFields, String fqdn, String nextPageId);
    Mono<GoogleDnsResponse>  getAllZonesWithValuesFromExternal (ZonesWithSOAAndNSGroupValues publicZones);
    Mono<ZonesWithSOAAndNSGroupValues> extractPublicZonesFromInternalInput(ZonesWithSOAAndNSGroupValues zones);
    Mono<ExternalDnsAnswer>  getSOARecordFromPublic(String zone);
    Flux<ExternalDnsAnswer> getIPAddressForNameservers();
}
