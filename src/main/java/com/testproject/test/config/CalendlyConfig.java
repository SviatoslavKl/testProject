package com.testproject.test.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@PropertySource("classpath:application.properties")
@ConfigurationProperties("calendly")
public class CalendlyConfig {
    private String apiKey;
    private String EventsUrl;

}
