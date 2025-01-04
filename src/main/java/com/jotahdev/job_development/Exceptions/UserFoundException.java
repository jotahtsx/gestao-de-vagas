package com.jotahdev.job_development.Exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já cadastrado no sistema. Verifique as informações e tente novamente.");
    }
}
