//package com.savemate.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Arrays;
//
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public CorsFilter corsFilter() {
//       
//        CorsConfiguration config = new CorsConfiguration();
//        
//        config.setAllowCredentials(true);
//        config.setAllowedOrigins(Arrays.asList("https://savemateapp.onrender.com",
//        		                      "https://savemateadmin.netlify.app",
//        		                      "http://savemateadmin.netlify.app",
//        		                      "http://localhost:3000"
//        		                        ));
//        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        config.addAllowedHeader("*");
//
//     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}
