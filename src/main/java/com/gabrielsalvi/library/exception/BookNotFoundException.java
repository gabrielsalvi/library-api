package com.gabrielsalvi.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends Exception {

    public BookNotFoundException(String bookTitle) {
        super(String.format("Não foi possível encontrar o livro '%s' na base de dados!", bookTitle));
    }

    public BookNotFoundException(Long id) {
        super(String.format("Não foi possível encontrar o livro de id '%s' na base de dados!", id));
    }
}
