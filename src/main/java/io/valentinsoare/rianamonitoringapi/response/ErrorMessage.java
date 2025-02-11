package io.valentinsoare.rianamonitoringapi.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Error Message")
public class ErrorMessage {
    @NotNull
    @Schema(description = "Time Stamp")
    private String timeStamp;

    @Size(min = 1, max = 100)
    @NotBlank(message = "Exception Name is mandatory")
    @Schema(description = "Exception Name")
    private String exceptionName;

    @Size(min = 1, max = 5)
    @Schema(description = "Level")
    @NotBlank(message = "Level is mandatory")
    private String level;

    @Size(min = 1, max = 500)
    @Schema(description = "Error Message")
    @NotBlank(message = "Error Message is mandatory")
    private String errorMessage;

    @Schema(description = "Status Code")
    @Min(value = 100, message = "Status Code must be greater than 100")
    private Integer statusCode;
}
