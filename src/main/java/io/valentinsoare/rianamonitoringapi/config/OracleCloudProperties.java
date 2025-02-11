package io.valentinsoare.rianamonitoringapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "oracle-cloud")
public class OracleCloudProperties {
    private List<String> nameservers;
}
