package com.picture.service.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.List;

@Configuration
@PropertySources({@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)})
@Getter
public class PropertyConfig {

    @Value("${file.upload.base-directory}")
    private String baseDirectory;

    @Value("${image.categories}")
    private List<String> imageCategories;

    @Value("${image.extensions}")
    private List<String> imageExtensions;
}
