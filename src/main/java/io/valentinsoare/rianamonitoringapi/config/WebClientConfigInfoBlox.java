package io.valentinsoare.rianamonitoringapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfigInfoBlox {
    @Value("${infoBlox.username}")
    private String userName;

    @Value("${infoBlox.password}")
    private String password;

    @Value("${infoBlox.infoBloxUrl}")
    private String infoBloxUrl;

    @Value("${infoBlox.bufferSize}")
    private Integer bufferSize;

    private static WebClient webClientForInfoBlox;

    public WebClient getWebClientForInfoBlox() {
        if (webClientForInfoBlox == null) {
            webClientForInfoBlox = WebClient.builder()
                    .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(bufferSize * 1024 * 1024))
                    .baseUrl(infoBloxUrl)
                    .defaultHeaders(httpHeaders -> httpHeaders.setBasicAuth(userName, password))
                    .build();
        }

        return webClientForInfoBlox;
    }
}
