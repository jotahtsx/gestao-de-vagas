package com.jotahdev.job_development.Modules.Candidate.UseCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotahdev.job_development.Modules.Company.Entities.JobEntity;
import com.jotahdev.job_development.Modules.Company.Repositories.JobRepository;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;
    
    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContaining(filter);
    }

}
