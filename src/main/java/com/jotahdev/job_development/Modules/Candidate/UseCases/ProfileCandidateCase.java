package com.jotahdev.job_development.Modules.Candidate.UseCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotahdev.job_development.Modules.Candidate.Repositories.CandidateRepository;

@Service
public class ProfileCandidateCase {
    
    @Autowired
    private CandidateRepository candidateRepository;


}
