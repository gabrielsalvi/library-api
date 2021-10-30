package com.gabrielsalvi.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenreNotFoundException extends Exception {

    public GenreNotFoundException(Long id) {
        super(String.format("Não foi possível encontrar o genero de id '%s' na base de dados!", id));
    }
}
