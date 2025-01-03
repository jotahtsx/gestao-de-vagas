package com.jotahdev.job_development.Modules.Candidate.Exceptions;

public class CandidateFoundException extends RuntimeException {
    public CandidateFoundException() {
        super("Candidato já cadastrado. Tente usar outro email ou nome de usuário.");
    }
}
