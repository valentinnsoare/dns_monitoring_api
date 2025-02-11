package io.valentinsoare.rianamonitoringapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@Schema(description = "Stripped Down External DNS Answer")
public class StripedDownExternalDnsAnswer {
    @JsonProperty("fqdn")
    @Schema(description = "Fully Qualified Domain Name")
    private String fqdn;

    @JsonProperty("soa_serial_number")
    @Schema(description = "SOA Serial Number")
    private String soaSerialNumber;
}
