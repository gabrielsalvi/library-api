package com.gabrielsalvi.library.exception;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(String bookTitle) {
        super(String.format("Não foi possível encontrar o livro '%s' na base de dados!", bookTitle));
    }
}
