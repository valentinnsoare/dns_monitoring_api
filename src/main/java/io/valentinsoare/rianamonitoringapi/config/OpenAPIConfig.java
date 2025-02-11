package io.valentinsoare.rianamonitoringapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public GroupedOpenApi actuatorApi() {
        return GroupedOpenApi
                .builder()
                .group("Actuator")
                .pathsToMatch("/api/v1/riana/monitoring/actuator/**")
                .build();
    }

    @Bean
    public GroupedOpenApi customOpenAPI() {
        return GroupedOpenApi
                .builder()
                .group("Riana Monitoring API")
                .pathsToMatch("/api/v1/riana/monitoring/zone/**")
                .build();
    }

    @Bean
    public OpenAPI rianaMonitoringAPI(
            @Value("${openapi.title:Default Title}") String title,
            @Value("${openapi.version:1.0.0}") String version,
            @Value("${openapi.description:Default Description}") String description
    ) {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description(description)
                        .contact(new Contact()
                                .name("Valentin Soare")
                                .email("soarevalentinn@lseg.com")
                                .url("https://www.linkedin.com/in/valentin-soare")
                        )
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")
                        )
                        .termsOfService("http://swagger.io/terms/")
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Riana Monitoring API Documentation and Source Code")
                        .url("https://gitlab.dx1.lseg.com/app/app-52146/riana_automation/riana_monitoring")
                );
    }
}
