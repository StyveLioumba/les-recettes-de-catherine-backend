package com.bdx.anais.ApplicationRecetteCuisine.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:4200",
                                "https://les-recettes-de-catherine.fr",
                                "https://dev.les-recettes-de-catherine.fr",
                                "https://www.les-recettes-de-catherine.fr",
                                "https://www.dev.les-recettes-de-catherine.fr"
                        )//angular port
                        .allowedMethods(
                                HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.PUT.name(),
                                HttpMethod.DELETE.name()
                        )
                        .allowedHeaders(
                                HttpHeaders.AUTHORIZATION,
                                HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.ACCEPT
                        )
                        .allowCredentials(true);
            }
        };
    }
}
