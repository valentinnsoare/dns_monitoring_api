package io.valentinsoare.rianamonitoringapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@Builder
@Schema(description = "Zones With SOA And NS Group Values")
public class ZonesWithSOAAndNSGroupValues {
    @JsonProperty("next_page_id")
    @Schema(description = "Next Page ID")
    private String next_page_id;

    @JsonProperty("result")
    @Schema(description = "Result")
    private List<ZoneSoaRequest> result;
}
