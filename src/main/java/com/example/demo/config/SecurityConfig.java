package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            // 🚫 NO AUTHENTICATION AT ALL
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )

            // 🚫 DISABLE BASIC AUTH (THIS CAUSES POPUP)
            .httpBasic(httpBasic -> httpBasic.disable())

            // 🚫 DISABLE FORM LOGIN
            .formLogin(form -> form.disable());

        return http.build();
    }
}
