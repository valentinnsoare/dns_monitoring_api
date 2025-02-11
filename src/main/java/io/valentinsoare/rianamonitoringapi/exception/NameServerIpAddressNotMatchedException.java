package io.valentinsoare.rianamonitoringapi.exception;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NameServerIpAddressNotMatchedException extends RuntimeException implements CustomException {
    private String errorMessage;
    private Integer statusCode;
}
