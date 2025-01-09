package com.jotahdev.job_development.Modules.Company.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class CreateJobDTO {
    
    @Schema(example = "Vaga para pessoa desenvolvedora JUNIOR", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "Gympass, plano de saúde", requiredMode = RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "JUNIOR", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
