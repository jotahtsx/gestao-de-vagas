package com.jotahdev.jobmanagement.modules.Candidate.Entities;

import java.util.UUID;

import com.jotahdev.jobmanagement.Validations.Annotations.ValidPassword;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @Pattern(regexp = "^[a-z0-9._]+$", message = "O campo de usuário só pode conter letras minúsculas, números, pontos e sublinhados")
    private String username;

    @Email(message = "O email deve ser válido")
    private String email;

    @ValidPassword
    private String password;
    private String description;
    private String resume;
}
