package com.jotahdev.job_development.Modules.Candidate.UseCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jotahdev.job_development.Modules.Candidate.Dto.ProfileCandidadeResponseDTO;
import com.jotahdev.job_development.Modules.Candidate.Repositories.CandidateRepository;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidadeResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException(
                            "Usuário não encontrado. Verifique as informações fornecidas e tente novamente.");
                });

        var candidateDTO = ProfileCandidadeResponseDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();
        return candidateDTO;
    }
}
