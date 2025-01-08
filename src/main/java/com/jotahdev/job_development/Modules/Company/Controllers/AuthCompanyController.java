package com.jotahdev.job_development.Modules.Company.Controllers;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotahdev.job_development.Modules.Company.Dto.AuthCompanyDTO;
import com.jotahdev.job_development.Modules.Company.UseCases.AuthCompanyUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresa")
public class AuthCompanyController {

    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;

    @PostMapping("/auth")
    public ResponseEntity<Object> create(@Valid @RequestBody AuthCompanyDTO authCompanyDTO) {
        try {
            var result = authCompanyUseCase.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno no servidor. Por favor, tente novamente mais tarde.");
        }
    }
}
