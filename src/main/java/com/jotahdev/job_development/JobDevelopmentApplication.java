package com.jotahdev.job_development;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Gestão de Vagas",
		description = "API responsável pela gestão de vagas",
		version = "1"
	)
)
public class JobDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobDevelopmentApplication.class, args);
	}
}
