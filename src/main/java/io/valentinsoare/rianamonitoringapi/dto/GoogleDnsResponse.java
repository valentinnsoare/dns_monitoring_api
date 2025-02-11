package io.valentinsoare.rianamonitoringapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@Builder
@Schema(description = "Google DNS Response")
public class GoogleDnsResponse {
    @JsonProperty("_next_page_id")
    @Schema(description = "Next Page ID")
    private String nextPageId;

    @JsonProperty("Answer")
    @Schema(description = "Answer")
    private List<ExternalDnsAnswer> answer;
}
