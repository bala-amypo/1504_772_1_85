package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // ✅ Main security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // ❌ Disable CSRF for APIs & Swagger
            .csrf(csrf -> csrf.disable())

            // ✅ Authorization rules
            .authorizeHttpRequests(auth -> auth
                // 🔓 Swagger should be PUBLIC
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                // 🔓 Allow login / register APIs if you have them
                .requestMatchers(
                    "/api/auth/**"
                ).permitAll()

                // 🔐 All other APIs need authentication
                .anyRequest().authenticated()
            )

            // ✅ Use HTTP Basic (simple, works well with Swagger)
            .httpBasic(Customizer.withDefaults())

            // ❌ Disable form login (removes /login page redirect)
            .formLogin(form -> form.disable());

        return http.build();
    }

    // ✅ Password encoder (REQUIRED)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
