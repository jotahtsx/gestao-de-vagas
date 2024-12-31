package com.jotahdev.job_development.modules.candidate.Exceptions;

public class CandidateFoundException extends RuntimeException {
    public CandidateFoundException() {
        super("Candidato já cadastrado. Tente usar outro email ou nome de usuário.");
    }
}
