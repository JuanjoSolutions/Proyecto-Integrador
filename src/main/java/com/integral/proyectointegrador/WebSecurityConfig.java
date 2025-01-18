package com.integral.proyectointegrador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        // Permite el acceso sin autenticación a H2 Console
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                // Desactiva CSRF para que la consola H2 funcione
                .csrf(csrf -> csrf.disable())
                // Desactiva frameOptions para poder mostrar la consola en un <frame>
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                // Autenticación básica (puede ser lo que quieras)
                .httpBasic(withDefaults())
                .build();
    }
}

