package com.dailycodebuffer.oauthresourceserver.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class ResourceServerConfig {

        @Bean
        SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(authorize -> authorize
                            .requestMatchers("/api/**")
                            .hasAuthority("SCOPE_api.read") // Directly use hasAuthority
                    )
                    .oauth2ResourceServer(oauth2 -> oauth2
                            .jwt(jwt -> jwt
                                    .jwkSetUri("http://Oauth-authorization-server/oauth2/jwks")
                            )
                    );
            return http.build();
        }

    }
