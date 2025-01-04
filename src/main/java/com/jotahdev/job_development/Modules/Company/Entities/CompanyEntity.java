package com.jotahdev.job_development.Modules.Company.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "companies")
@Data
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "O nome de usuário deve conter apenas letras, números e underscores. Não é permitido o uso de espaços ou caracteres especiais, como acentos ou símbolos.")
    private String username;

    @Email(message = "Por favor, insira um email válido.")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#\\$%^&\\*])(?=\\S+$).{8,16}$", message = "A senha deve ter entre 8 e 16 caracteres, incluindo pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial.")
    private String password;

    @Pattern(regexp = "^(http://|https://).*", message = "A URL deve começar com http:// ou https://")
    private String url;

    @Pattern(regexp = "^[0-9]{14}$", message = "O CNPJ deve conter exatamente 14 dígitos numéricos.")
    private String document;
    
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
