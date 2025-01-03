package com.jotahdev.job_development.Modules.Candidate.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateErrorMessage {    

    private String message;
    private String field;
}
