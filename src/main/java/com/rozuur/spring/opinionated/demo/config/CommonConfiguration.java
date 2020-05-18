package com.rozuur.spring.opinionated.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class CommonConfiguration {
    @Value("${management.endpoints.web.path-mapping.health:/actuator/health}")
    private String healthEndpointPath;

    @Bean
    public CommonsRequestLoggingFilter loggingFilter() {
        return new RequestLoggingFilter(healthEndpointPath);
    }
}
