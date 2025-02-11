package io.valentinsoare.rianamonitoringapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@Schema(description = "Zone SOA Request")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZoneSoaRequest {
    @JsonProperty("fqdn")
    @Schema(description = "Fully Qualified Domain Name")
    private String fqdn;

    @JsonProperty("ns_group")
    @Schema(description = "NS Group")
    private String nsGroup;

    @JsonProperty("soa_serial_number")
    @Schema(description = "SOA Serial Number")
    private Integer soaSerialNumber;

    @JsonProperty("zone_format")
    @Schema(description = "Zone Format")
    private String zoneFormat;
}
