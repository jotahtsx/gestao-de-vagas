package com.jotahdev.job_development.Modules.Company.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotahdev.job_development.Exceptions.UserFoundException;
import com.jotahdev.job_development.Modules.Company.Entities.CompanyEntity;
import com.jotahdev.job_development.Modules.Company.Repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        if (companyRepository.existsByUsername(companyEntity.getUsername())) {
            throw new RuntimeException(
                    "Nome de usuário da empresa já cadastrado no sistema. Verifique as informações e tente novamente.");
        }

        if (companyRepository.existsByEmail(companyEntity.getEmail())) {
            throw new RuntimeException(
                    "Email da empresa já cadastrado no sistema. Verifique as informações e tente novamente.");
        }

        if (companyRepository.existsByDocument(companyEntity.getDocument())) {
            throw new RuntimeException("CNPJ já cadastrado no sistema. Verifique as informações e tente novamente.");
        }

        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);
    }

}
