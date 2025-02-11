package io.valentinsoare.rianamonitoringapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfigGoogle {
    @Value("${googleDnsResolver.googleResolverUrl}")
    private String googleResolverUrl;

    @Value("${googleDnsResolver.bufferSize}")
    private Integer bufferSize;

    private static WebClient webClientForGoogle;

    public WebClient getWebClientForGoogle() {
        if (webClientForGoogle == null) {
            webClientForGoogle = WebClient.builder()
                    .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(bufferSize * 1024 * 1024))
                    .baseUrl(googleResolverUrl)
                    .build();
        }

        return webClientForGoogle;
    }
}
