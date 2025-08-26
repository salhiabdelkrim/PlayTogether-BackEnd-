package com.example.PlayTogether.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()  // allow all requests
            )
            .csrf().disable() // disable CSRF (for forms or APIs)
            .formLogin().disable(); // disable login form
        return http.build();
    }
}