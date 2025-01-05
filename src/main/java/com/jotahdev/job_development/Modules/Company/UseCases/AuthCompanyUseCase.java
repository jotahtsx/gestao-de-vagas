package com.jotahdev.job_development.Modules.Company.UseCases;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jotahdev.job_development.Modules.Company.Dto.AuthCompanyDTO;
import com.jotahdev.job_development.Modules.Company.Repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = companyRepository.findByUsername(authCompanyDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Usuário não encontrado. Verifique o nome de usuário e tente novamente."));

        var passwordMatches = passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());
        if (!passwordMatches) {
            throw new AuthenticationException("Senha incorreta. Verifique e tente novamente.");
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withIssuer("javagas")
                .withSubject(company.getId().toString())
                .sign(algorithm);
    }
}
