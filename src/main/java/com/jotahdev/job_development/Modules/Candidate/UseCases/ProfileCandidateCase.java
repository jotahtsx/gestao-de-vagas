package com.jotahdev.job_development.Modules.Candidate.UseCases;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.jotahdev.job_development.Modules.Candidate.Dto.ProfileCandidateResponseDTO;
import com.jotahdev.job_development.Modules.Candidate.Repositories.CandidateRepository;

@Service
public class ProfileCandidateCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException(
                            "Candidato não encontrado. Verifique as informações fornecidas e tente novamente.");
                });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();

        return candidateDTO;
    }
}
