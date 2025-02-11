package io.valentinsoare.rianamonitoringapi.util;

import io.valentinsoare.rianamonitoringapi.exception.*;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Exceptions;
import reactor.util.retry.Retry;

import java.time.Duration;

@Slf4j
public class RetryUtil {
    public static Retry retrySpec(int maxRetries, int retryDelay) {
        return Retry.backoff(maxRetries, Duration.ofSeconds(retryDelay))
                .filter(ex -> ex instanceof AllInternalZonesException || ex instanceof NameServerToIpAddressException ||
                        ex instanceof PublicZonesFromInternalException || ex instanceof StartOfAuthorityOfAllPublicZonesFromExternalException ||
                        ex instanceof StartOfAuthorityValueFromPublicZoneException)
                .jitter(0.5)
                .doBeforeRetry(s -> log.info("Retrying..."))
                .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> Exceptions.propagate(retrySignal.failure()));
    }
}
