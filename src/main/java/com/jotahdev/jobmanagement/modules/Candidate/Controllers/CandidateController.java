package com.jotahdev.jobmanagement.modules.Candidate.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotahdev.jobmanagement.modules.Candidate.Entities.CandidateEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidato")
public class CandidateController {

    @PostMapping("/")
    public void create(@Valid @RequestBody CandidateEntity candidateEntity) {
        System.out.println("Candidato");
        System.out.println(candidateEntity.getEmail());
    }
}