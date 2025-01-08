package com.jotahdev.job_development.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Autowired
    private SecurityCandidateFilter securityCandidateFilter;

    private static final String[] SWAGGER_LIST = {
        "/swagger-ui/**",
        "/v3/api-docs/**",
        "/swagger-resources/**"
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/candidato/", "/empresa/").permitAll() // Dá o acesso as duas rotas
                        .requestMatchers("/empresa/auth").permitAll()
                        .requestMatchers("/candidato/auth").permitAll()
                        .requestMatchers(SWAGGER_LIST).permitAll()
                        .anyRequest().authenticated() // Exige autenticação para qualquer outra rota
                )
                .addFilterBefore(securityCandidateFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(securityFilter, BasicAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
