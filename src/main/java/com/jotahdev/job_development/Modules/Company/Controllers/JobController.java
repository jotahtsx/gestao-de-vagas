package com.jotahdev.job_development.Modules.Company.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotahdev.job_development.Modules.Company.Entities.JobEntity;
import com.jotahdev.job_development.Modules.Company.UseCases.CreateJobUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vaga")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity) {
        return this.createJobUseCase.execute(jobEntity);
    }

}
