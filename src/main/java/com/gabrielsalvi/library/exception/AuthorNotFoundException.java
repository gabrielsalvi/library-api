package com.gabrielsalvi.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends Exception {

    public AuthorNotFoundException(Long id) {
        super(String.format("Não foi possível encontrar o autor de id '%s' na base de dados!", id));
    }
}
