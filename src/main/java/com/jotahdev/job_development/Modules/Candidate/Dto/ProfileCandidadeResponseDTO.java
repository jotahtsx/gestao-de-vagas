package com.jotahdev.job_development.Modules.Candidate.Dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidadeResponseDTO {
    
    private String description;
    private String username;
    private String email;
    private UUID id;
    private String name;
}
