package com.jotahdev.job_development.Modules.Company.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {
    
    @NotBlank(message = "O nome de usuário não pode estar vazio.")
    @Pattern(regexp = "^[a-z0-9_]+$", message = "O nome de usuário deve conter apenas letras minúsculas, números e underscores.")
    private String username;

    @NotBlank(message = "A senha não pode estar vazia.")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$",
        message = "A senha deve ter pelo menos 8 caracteres, incluindo uma letra maiúscula, uma letra minúscula, um número e um caractere especial."
    )
    private String password;
}