package com.jotahdev.job_development.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
        .info(new Info().title("Gestão de vagas").description("Api responsável pela gestão de vagas").version("1")).schemaRequirement("jwt_auth", creaSecurityScheme());
    }

    private SecurityScheme creaSecurityScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP).name("jwt_auth").scheme("bearer").bearerFormat("JWT");
    }
}
