package com.jotahdev.job_development.Modules.Candidate.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotahdev.job_development.Modules.Candidate.Entities.CandidateEntity;
import com.jotahdev.job_development.Modules.Candidate.Repositories.CandidateRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidato")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity) {
        return this.candidateRepository.save(candidateEntity);
    }
}
