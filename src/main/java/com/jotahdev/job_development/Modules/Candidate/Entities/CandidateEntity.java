package com.jotahdev.job_development.Modules.Candidate.Entities;

import java.util.UUID;

import lombok.Data;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String resume;
}
