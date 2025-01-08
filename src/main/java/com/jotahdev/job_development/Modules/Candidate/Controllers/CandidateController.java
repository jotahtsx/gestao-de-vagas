package com.jotahdev.job_development.Modules.Candidate.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jotahdev.job_development.Modules.Candidate.Entities.CandidateEntity;
import com.jotahdev.job_development.Modules.Candidate.UseCases.CreateCandidateUseCase;
import com.jotahdev.job_development.Modules.Candidate.UseCases.ProfileCandidateCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidato")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @Autowired
    private ProfileCandidateCase profileCandidateCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATO')")
    public ResponseEntity<Object> get(HttpServletRequest request) {

        var idCandidate = request.getAttribute("candidate_id");

        try {
            var profile = this.profileCandidateCase.execute(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
