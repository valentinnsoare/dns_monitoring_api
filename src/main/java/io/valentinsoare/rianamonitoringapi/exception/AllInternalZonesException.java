package io.valentinsoare.rianamonitoringapi.exception;

import lombok.*;

@Getter
public class AllInternalZonesException extends RuntimeException implements CustomException {
    private String errorMessage;
    private Integer statusCode;
}
