package com.gabrielsalvi.library.controller;

import com.gabrielsalvi.library.entity.Author;
import com.gabrielsalvi.library.entity.Book;
import com.gabrielsalvi.library.exception.AuthorNotFoundException;
import com.gabrielsalvi.library.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody @Valid Author author) {
        return authorService.create(author);
    }

    @GetMapping
    public List<Author> listAuthors() {
        return authorService.listAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) throws AuthorNotFoundException {
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    public Author updateById(@PathVariable Long id, @RequestBody @Valid Author author) throws AuthorNotFoundException {
        return authorService.update(id, author);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws AuthorNotFoundException {
        authorService.delete(id);
    }

    @GetMapping("/{id}/books")
    public List<Book> getBooksOfTheAuthor(@PathVariable Long id) throws AuthorNotFoundException {
        return authorService.listBooksOfTheAuthor(id);
    }
}