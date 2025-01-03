package com.jotahdev.job_development.Modules.Candidate.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotahdev.job_development.Modules.Candidate.Entities.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    
}
