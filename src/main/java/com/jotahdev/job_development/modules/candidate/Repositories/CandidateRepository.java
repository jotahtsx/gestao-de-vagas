package com.jotahdev.job_development.modules.candidate.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotahdev.job_development.modules.candidate.Entities.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    
}
