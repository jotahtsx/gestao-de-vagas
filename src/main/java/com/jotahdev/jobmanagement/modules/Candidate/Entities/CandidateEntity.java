package com.jotahdev.jobmanagement.modules.Candidate.Entities;

import lombok.Data;

@Data
public class CandidateEntity {
    
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String resume;
}
