package com.jotahdev.jobmanagement.Validations.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.jotahdev.jobmanagement.Validations.Validators.PasswordValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER}) // Pode ser usada em atributos ou parâmetros de métodos
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "A senha deve ter entre 8 e 64 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}