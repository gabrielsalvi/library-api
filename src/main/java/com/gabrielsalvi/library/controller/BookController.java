package com.gabrielsalvi.library.controller;

import com.gabrielsalvi.library.entity.Book;
import com.gabrielsalvi.library.exception.BookNotFoundException;
import com.gabrielsalvi.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody @Valid Book book) {
        return bookService.create(book);
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookService.listAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable Long id, @RequestBody @Valid Book book) throws BookNotFoundException {
        bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BookNotFoundException {
        bookService.delete(id);
    }
}