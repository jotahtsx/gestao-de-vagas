package com.jotahdev.job_development.Modules.Company.Repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotahdev.job_development.Modules.Company.Entities.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByDocument(String document);

    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
    CompanyEntity findByUsername(String username);
}
