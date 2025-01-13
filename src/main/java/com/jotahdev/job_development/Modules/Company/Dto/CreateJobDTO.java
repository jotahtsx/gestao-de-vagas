package com.jotahdev.job_development.Modules.Company.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class CreateJobDTO {
    @Schema(example = "Estamos buscando um Desenvolvedor Júnior com conhecimento básico em Java e Spring Boot. Responsável por desenvolver e dar manutenção em aplicações web, colaborar com a equipe de desenvolvimento e aprender novas tecnologias. Não é necessário experiência prévia, mas é desejável conhecimento em Git e APIs REST", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "GymPass, Vale-transporte, Academia, Plano de saúde, Home office 2x por semana", requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "JUNIOR", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
