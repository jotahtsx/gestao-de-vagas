package com.jotahdev.job_development.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/candidato/", "/empresa/").permitAll() // Dá o acesso as duas rotas
                        .anyRequest().authenticated() // Exige autenticação para qualquer outra rota
                );
        return http.build();
    }
}
