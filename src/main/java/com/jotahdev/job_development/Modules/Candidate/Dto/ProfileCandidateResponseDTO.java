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
public class ProfileCandidateResponseDTO {
    @Schema(example = "Desenvolvedora Java")
    private String description;
    @Schema(example = "mariaross22")
    private String username;
    @Schema(example = "maria.rosana@gmail.com")
    private String email;
    private UUID id;
    @Schema(example = "Maria Rosana")
    private String name;

}
