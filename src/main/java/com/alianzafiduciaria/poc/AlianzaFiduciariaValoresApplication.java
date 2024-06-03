package com.alianzafiduciaria.poc;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class AlianzaFiduciariaValoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlianzaFiduciariaValoresApplication.class, args);
	}
	
	 @Bean
     public CorsFilter corsFilter() {
         final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
         final CorsConfiguration config = new CorsConfiguration();
         config.setAllowedOrigins(Collections.singletonList("*"));
         config.setAllowedHeaders(Collections.singletonList("*"));
         config.setAllowedOriginPatterns(Collections.singletonList("*"));
         config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
         source.registerCorsConfiguration("/**", config);
         return new CorsFilter(source);
     }

}
