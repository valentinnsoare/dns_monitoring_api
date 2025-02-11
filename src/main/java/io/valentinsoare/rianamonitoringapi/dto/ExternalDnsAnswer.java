package io.valentinsoare.rianamonitoringapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@Schema(description = "External DNS Answer")
public class ExternalDnsAnswer {
    @JsonProperty("name")
    @Schema(description = "Name of the DNS record")
    private String name;

    @JsonProperty("type")
    @Schema(description = "Type of the DNS record")
    private int type;

    @JsonProperty("TTL")
    @Schema(description = "Time to live of the DNS record")
    private int TTL;

    @JsonProperty("data")
    @Schema(description = "Data of the DNS record")
    private String data;
}
