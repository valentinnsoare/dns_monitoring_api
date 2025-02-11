package io.valentinsoare.rianamonitoringapi.service;

import io.valentinsoare.rianamonitoringapi.dto.ExternalDnsAnswer;
import io.valentinsoare.rianamonitoringapi.dto.GoogleDnsResponse;
import io.valentinsoare.rianamonitoringapi.dto.ZonesWithSOAAndNSGroupValues;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.util.List;

public interface ActionsOnDnsInputService {
    void checkStartOfAuthorityValues(ZonesWithSOAAndNSGroupValues soaValuesFromInfoBlox, GoogleDnsResponse soaValuesFromGoogleResolver);
    void checkNameServerValues();
    void checkNameserverIPAddresses(ExternalDnsAnswer externalDnsAnswer);
    void runTasksFromInput(String[] arguments, InputStream inputStream);
    void executeTasks(List<String> options);
    void startComparisonOfSoaValues();
}
