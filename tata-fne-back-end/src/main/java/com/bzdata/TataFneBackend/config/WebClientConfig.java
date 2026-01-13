package com.bzdata.TataFneBackend.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.bzdata.TataFneBackend.Property.FneProperties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
@EnableConfigurationProperties(FneProperties.class)
public class WebClientConfig {

    @Bean
   
    WebClient fneWebClient(FneProperties fneProperties) {
        return WebClient.builder()
                .baseUrl(fneProperties.getBaseUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer " + fneProperties.getBearerToken())
                .build();
    }
}
