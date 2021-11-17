package com.gabrielsalvi.library.service;

import com.gabrielsalvi.library.entity.Book;
import com.gabrielsalvi.library.exception.BookNotFoundException;
import com.gabrielsalvi.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) throws BookNotFoundException {
        Book book =  bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        return book;
    }

    public void update(Long id, Book book) throws BookNotFoundException {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setGenres(book.getGenres());
        bookToUpdate.setAuthors(book.getAuthors());
        bookToUpdate.setPages(book.getPages());

        bookRepository.save(bookToUpdate);
    }

    public void delete(@PathVariable Long id) throws BookNotFoundException {
        Book bookToDelete = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        bookRepository.delete(bookToDelete);
    }
}
