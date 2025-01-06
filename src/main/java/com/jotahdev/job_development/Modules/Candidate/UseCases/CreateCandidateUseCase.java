package com.jotahdev.job_development.Modules.Candidate.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jotahdev.job_development.Exceptions.UserFoundException;
import com.jotahdev.job_development.Modules.Candidate.Entities.CandidateEntity;
import com.jotahdev.job_development.Modules.Candidate.Repositories.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        if (!isUsernameValid(candidateEntity.getUsername())) {
            throw new RuntimeException(
                    "O nome de usuário deve conter apenas letras minúsculas, números e underscores.");
        }

        if (!isEmailValid(candidateEntity.getEmail())) {
            throw new RuntimeException("Por favor, insira um email válido.");
        }

        if (!isPasswordValid(candidateEntity.getPassword())) {
            throw new RuntimeException(
                    "A senha deve ter entre 8 e 16 caracteres, incluindo pelo menos uma letra maiúscula, uma letra minúscula e um número.");
        }

        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        candidateEntity.setPassword(passwordEncoder.encode(candidateEntity.getPassword()));

        return this.candidateRepository.save(candidateEntity);
    }

    private boolean isUsernameValid(String username) {
        return username != null && username.matches("^^[a-z0-9_]+$");
    }

    private boolean isEmailValid(String email) {
        return email != null
                && email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,16}$");
    }
}
