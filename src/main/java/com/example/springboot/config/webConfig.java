package com.example.springboot.config;

import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Source;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration

public class webConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter>corsFilterFilterRegistrationBean(){

        List<String> all = Arrays.asList("*");
     CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(all);
        configuration.setAllowedMethods(all);
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(all);
         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        CorsFilter corsFilter = new CorsFilter();
        FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>(corsFilter);
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);    
        return filter;
        
       }


    }

