package com.bzdata.TataFneBackend.Property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@ConfigurationProperties(prefix = "fne")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Getter
@Setter
public class FneProperties {
    String baseUrl;
    String signPath;
    String bearerToken;
}

