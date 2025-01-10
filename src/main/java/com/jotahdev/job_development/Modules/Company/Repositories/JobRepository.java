package com.jotahdev.job_development.Modules.Company.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotahdev.job_development.Modules.Company.Entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
