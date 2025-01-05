package com.jotahdev.job_development.Modules.Company.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {
    
    private String password;
    private String username;
}
