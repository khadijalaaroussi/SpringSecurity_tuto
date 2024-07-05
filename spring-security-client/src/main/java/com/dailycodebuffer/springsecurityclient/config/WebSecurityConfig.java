package com.dailycodebuffer.springsecurityclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
 private static final String[] WHITE_LIST_URLS={
         "/hello","/register"
 };
 @Bean
 public PasswordEncoder passwordEncoder(){
  return new BCryptPasswordEncoder(11);
 }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults()) // Configure CORS with defaults
                .csrf(csrf -> csrf.disable())// Disable CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/hello","/register","/verifyRegistration","/resendVerifyToken*","/resetPassword","/savePassword","/changePassword").permitAll() // Whitelist URLs for permitAll
                        .requestMatchers("/api/**").authenticated() // Require authentication for /api/**
                )
                .oauth2Login(oauth2login ->
                        oauth2login.loginPage("/oauth2/authorization/api-client-oidc")
                )
                .oauth2Client(Customizer.withDefaults());

        return http.build();
    }
}


