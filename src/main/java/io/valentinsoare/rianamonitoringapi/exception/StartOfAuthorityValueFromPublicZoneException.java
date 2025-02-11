package io.valentinsoare.rianamonitoringapi.exception;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartOfAuthorityValueFromPublicZoneException extends RuntimeException implements CustomException {
    private String errorMessage;
    private Integer statusCode;
}
