package org.guedim.externalizeconfig.configuration;

import org.guedim.externalizeconfig.properties.ApplicationProperties;
import org.guedim.externalizeconfig.properties.AwsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {ApplicationProperties.class, AwsProperties.class})
@Configuration
public class ApplicationConfig {
}
