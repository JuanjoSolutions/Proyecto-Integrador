package com.integral.proyectointegrador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                // Autoriza cualquier request a /h2-console sin autenticación
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().permitAll()
                )
                // Desactiva CSRF (la consola H2 usa frames y forms internos)
                .csrf(csrf -> csrf.disable())
                // Permite que la consola H2 funcione en un <frame> (por defecto está bloqueado)
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .build();
    }
}

