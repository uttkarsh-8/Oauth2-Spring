package com.Oauthsec.Oauthsec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())  // Disabling CSRF protection for APIs or where appropriate
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated())  // Require authentication for all requests
                .oauth2Login();  // Enable OAuth2 login configuration

        return http.build();

    }
}
