package io.valentinsoare.rianamonitoringapi.exception;

import io.valentinsoare.rianamonitoringapi.response.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({
            AllInternalZonesException.class,
            NameServerIpAddressNotMatchedException.class,
            NameServerToIpAddressException.class,
            PublicZonesFromInternalException.class,
            StartOfAuthorityOfAllPublicZonesFromExternalException.class,
            StartOfAuthorityValueFromPublicZoneException.class,
            StartOfAuthorityValueNotMatchedException.class
    })
    public ResponseEntity<ErrorMessage> handleMonitoringRianaExceptions(RuntimeException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timeStamp(Instant.now().toString())
                .exceptionName(ex.getClass().getSimpleName())
                .level("ERROR")
                .errorMessage(ex instanceof CustomException ? ((CustomException) ex).getErrorMessage() : ex.getMessage())
                .statusCode(ex instanceof CustomException ? ((CustomException) ex).getStatusCode() : 500)
                .build();

        log.error(errorMessage.toString());
        return ResponseEntity.status(errorMessage.getStatusCode()).body(errorMessage);
    }

    @ExceptionHandler({
            RuntimeException.class
    })
    public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timeStamp(Instant.now().toString())
                .exceptionName(ex.getClass().getSimpleName())
                .level("ERROR")
                .errorMessage(ex.getMessage())
                .statusCode(500)
                .build();

        log.error(errorMessage.toString());
        return ResponseEntity.status(500).body(errorMessage);
    }
}
