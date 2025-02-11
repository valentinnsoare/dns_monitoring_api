package io.valentinsoare.rianamonitoringapi.exception;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicZonesFromInternalException extends RuntimeException implements CustomException{
    private String errorMessage;
    private Integer statusCode;
}
