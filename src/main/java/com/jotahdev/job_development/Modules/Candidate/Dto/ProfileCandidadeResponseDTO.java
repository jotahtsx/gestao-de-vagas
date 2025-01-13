package com.jotahdev.job_development.Modules.Candidate.Dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidadeResponseDTO {
    
    @Schema(example = "Desenvolvedor Java")
    private String description;

    @Schema(example = "joaomanoelskai")
    private String username;

    @Schema(example = "joaomanoelskai@exemplo.com")
    private String email;
    private UUID id;

    @Schema(example = "João Manoel")
    private String name;
}
