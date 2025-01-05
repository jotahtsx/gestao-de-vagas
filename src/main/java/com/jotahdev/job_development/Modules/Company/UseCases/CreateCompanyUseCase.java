package com.jotahdev.job_development.Modules.Company.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jotahdev.job_development.Exceptions.UserFoundException;
import com.jotahdev.job_development.Modules.Company.Entities.CompanyEntity;
import com.jotahdev.job_development.Modules.Company.Repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        // Validação do username
        if (!isUsernameValid(companyEntity.getUsername())) {
            throw new RuntimeException(
                    "O nome de usuário deve conter apenas letras minúsculas, números e underscores.");
        }

        // Validação do email
        if (!isEmailValid(companyEntity.getEmail())) {
            throw new RuntimeException("Por favor, insira um email válido.");
        }

        // Validação da URL
        if (!isUrlValid(companyEntity.getUrl())) {
            throw new RuntimeException("A URL deve começar com http:// ou https://");
        }

        // Validação do CNPJ
        if (!isDocumentValid(companyEntity.getDocument())) {
            throw new RuntimeException("O CNPJ deve conter exatamente 14 dígitos numéricos.");
        }

        if (companyRepository.existsByUsername(companyEntity.getUsername())) {
            throw new RuntimeException("Nome de usuário da empresa já cadastrado no sistema.");
        }

        if (companyRepository.existsByEmail(companyEntity.getEmail())) {
            throw new RuntimeException("Email da empresa já está cadastrado no sistema.");
        }

        if (companyRepository.existsByDocument(companyEntity.getDocument())) {
            throw new RuntimeException("CNPJ já está cadastrado no sistema.");
        }

        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        if (!isPasswordValid(companyEntity.getPassword())) {
            throw new RuntimeException(
                    "A senha deve ter entre 8 e 16 caracteres, incluindo pelo menos uma letra maiúscula, uma letra minúscula e um número.");
        }

        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);

        return this.companyRepository.save(companyEntity);
    }

    private boolean isUsernameValid(String username) {
        return username != null && username.matches("^[a-z0-9_]+$");
    }

    private boolean isEmailValid(String email) {
        return email != null
                && email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

    private boolean isUrlValid(String url) {
        return url != null && url.matches("^(http://|https://).*");
    }

    private boolean isDocumentValid(String document) {
        return document != null && document.matches("^[0-9]{14}$");
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,16}$");
    }
}
