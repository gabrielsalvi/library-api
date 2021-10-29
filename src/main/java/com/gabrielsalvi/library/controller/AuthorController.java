package com.gabrielsalvi.library.controller;

import com.gabrielsalvi.library.entity.Author;
import com.gabrielsalvi.library.exception.AuthorNotFoundException;
import com.gabrielsalvi.library.exception.BookNotFoundException;
import com.gabrielsalvi.library.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody @Valid Author author) {
        return authorRepository.save(author);
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) throws AuthorNotFoundException {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }
}
