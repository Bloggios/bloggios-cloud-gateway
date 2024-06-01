package com.bloggios.cloud.gateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - bloggios-cloud-gateway
 * Package - com.bloggios.cloud.gateway.configuration
 * Created_on - 29 December-2023
 * Created_at - 13 : 24
 */

@Configuration
public class WebMvc {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(List.of(
                "http://localhost:2000",
                "https://bloggios.com",
                "https://bloggios.in",
                "https://www.bloggios.in",
                "https://www.bloggios.com",
                "https://dev.bloggios.in"
        ));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        corsConfig.addAllowedHeader("*");
        corsConfig.addExposedHeader("cookie-token");
        corsConfig.setAllowCredentials(true);

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return new CorsWebFilter(source);
    }
}
