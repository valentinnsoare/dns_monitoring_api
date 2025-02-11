package io.valentinsoare.rianamonitoringapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.valentinsoare.rianamonitoringapi.config.MonitoringDefaultValues;
import io.valentinsoare.rianamonitoringapi.dto.ExternalDnsAnswer;
import io.valentinsoare.rianamonitoringapi.dto.GoogleDnsResponse;
import io.valentinsoare.rianamonitoringapi.dto.ZonesWithSOAAndNSGroupValues;
import io.valentinsoare.rianamonitoringapi.service.DnsQueryServiceImpl;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/riana/monitoring")
@Tag(name = "DNSQueryController", description = "Controller for handling DNS query operations")
public class DnsQueryController {
    private final DnsQueryServiceImpl dnsServiceImpl;

    @Autowired
    public DnsQueryController(DnsQueryServiceImpl dnsServiceImpl) {
        this.dnsServiceImpl = dnsServiceImpl;
    }

    @GetMapping("/zone/internal/all")
    @Operation(
            summary = "Retrieve all internal zones",
            description = "Fetches all internal DNS zones with SOA and NS group values, supporting pagination and filtering by FQDN."
    )
    @ApiResponses(
            value = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved all internal zones"),
            }
    )
    public Mono<ResponseEntity<ZonesWithSOAAndNSGroupValues>> getAllZonesFromInternal(
            @RequestParam(value = "max_results_per_page", defaultValue = MonitoringDefaultValues.maxResults, required = false) int maxResults,
            @RequestParam(value = "paging", defaultValue = MonitoringDefaultValues.paging, required = false) int paging,
            @RequestParam(value = "return_as_object", defaultValue = MonitoringDefaultValues.returnAsObject, required = false) int returnAsObject,
            @RequestParam(value = "return_fields", defaultValue = MonitoringDefaultValues.returnFields, required = false) String returnFields,
            @RequestParam(value = "page_id", required = false) String nextPageId,
            @RequestParam(value = "fqdn", required = false) String fqdn
    ) {
        return dnsServiceImpl.getAllZonesWithValuesFromInternal(maxResults, paging, returnAsObject, returnFields, fqdn, nextPageId)
                .map(element -> new ResponseEntity<>(element, HttpStatus.OK));
    }

    @GetMapping("/zone/public/internal/all")
    @Operation(
            summary = "Retrieve all public zones from internal",
            description = "Fetches all public DNS zones from internal with SOA and NS group values, supporting pagination and filtering by FQDN."
    )
    @ApiResponses(
            value = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved all public zones from internal"),
            }
    )
    public Mono<ResponseEntity<ZonesWithSOAAndNSGroupValues>> getAllPublicZonesFromInternal(
            @RequestParam(value = "max_results_per_page", defaultValue = MonitoringDefaultValues.maxResults, required = false) int maxResults,
            @RequestParam(value = "paging", defaultValue = MonitoringDefaultValues.paging, required = false) int paging,
            @RequestParam(value = "return_as_object", defaultValue = MonitoringDefaultValues.returnAsObject, required = false) int returnAsObject,
            @RequestParam(value = "return_fields", defaultValue = MonitoringDefaultValues.returnFields, required = false) String returnFields,
            @RequestParam(value = "page_id", required = false) String nextPageId,
            @RequestParam(value = "fqdn", required = false) String fqdn
    ) {
        return dnsServiceImpl.getAllZonesWithValuesFromInternal(maxResults, paging, returnAsObject, returnFields, fqdn, nextPageId)
                .flatMap(dnsServiceImpl::extractPublicZonesFromInternalInput)
                                    .map(element -> new ResponseEntity<>(element, HttpStatus.OK));
    }

    @GetMapping("/zone/external/all")
    @Operation(
            summary = "Retrieve all zones from external",
            description = "Fetches all DNS zones from external with SOA and NS group values, supporting pagination and filtering by FQDN."
    )
    @ApiResponses(
            value = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved all zones from external"),
            }
    )
    public Mono<ResponseEntity<GoogleDnsResponse>> getAllZonesFromExternal(
            @RequestParam(value = "max_results_per_page", defaultValue = MonitoringDefaultValues.maxResults, required = false) int maxResults,
            @RequestParam(value = "paging", defaultValue = MonitoringDefaultValues.paging, required = false) int paging,
            @RequestParam(value = "return_as_object", defaultValue = MonitoringDefaultValues.returnAsObject, required = false) int returnAsObject,
            @RequestParam(value = "return_fields", defaultValue = MonitoringDefaultValues.returnFields, required = false) String returnFields,
            @RequestParam(value = "page_id", required = false) String nextPageId,
            @RequestParam(value = "fqdn", required = false) String fqdn
    ) {
        return dnsServiceImpl.getAllZonesWithValuesFromInternal(maxResults, paging, returnAsObject, returnFields, fqdn, nextPageId)
                .flatMap(dnsServiceImpl::extractPublicZonesFromInternalInput)
                .flatMap(dnsServiceImpl::getAllZonesWithValuesFromExternal)
                .map(element -> new ResponseEntity<>(element, HttpStatus.OK));
    }

    @GetMapping("/zone/external/soa-value")
    @Operation(
            summary = "Retrieve SOA value for a zone from external",
            description = "Fetches the SOA value for a zone from external DNS."
    )
    @ApiResponses(
            value = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved SOA value for a zone from external"),
            }
    )
    public Mono<ResponseEntity<ExternalDnsAnswer>> getOneZoneWithSoaValueFromExternal(
            @RequestParam(value = "zone") @NotNull  String zone
    ) {
        return dnsServiceImpl.getSOARecordFromPublic(zone)
                .map(element -> new ResponseEntity<>(element, HttpStatus.OK));
    }

    @GetMapping("/zone/external/ns-ip")
    @Operation(
            summary = "Retrieve IP address for nameservers from external",
            description = "Fetches the IP address for nameservers from external DNS."
    )
    @ApiResponses(
            value = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved IP address for nameservers from external"),
            }
    )
    public Flux<ExternalDnsAnswer> getIPAddressForNameservers() {
        return dnsServiceImpl.getIPAddressForNameservers();
    }
}
