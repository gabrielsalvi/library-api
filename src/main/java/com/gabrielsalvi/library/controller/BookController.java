package com.gabrielsalvi.library.controller;

import com.gabrielsalvi.library.entity.Book;
import com.gabrielsalvi.library.exception.BookNotFoundException;
import com.gabrielsalvi.library.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody @Valid Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) throws BookNotFoundException {
        Book book =  bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        return book;
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable Long id, @RequestBody @Valid Book book) throws BookNotFoundException {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setGenres(book.getGenres());
        bookToUpdate.setAuthors(book.getAuthors());
        bookToUpdate.setPages(book.getPages());

        bookRepository.save(bookToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws BookNotFoundException {
        Book bookToDelete = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        bookRepository.delete(bookToDelete);
    }

}
