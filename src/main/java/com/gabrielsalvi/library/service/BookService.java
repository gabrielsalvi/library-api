package com.gabrielsalvi.library.service;

import com.gabrielsalvi.library.entity.Book;
import com.gabrielsalvi.library.exception.BookNotFoundException;
import com.gabrielsalvi.library.repository.BookRepository;
import org.springframework.stereotype.Service;

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
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public void update(Long id, Book book) throws BookNotFoundException {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setGenres(book.getGenres());
        bookToUpdate.setAuthors(book.getAuthors());
        bookToUpdate.setPages(book.getPages());

        bookRepository.save(bookToUpdate);
    }

    public void delete(Long id) throws BookNotFoundException {
        Book bookToDelete = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        bookRepository.delete(bookToDelete);
    }

    public List<Book> getBooksOfTheAuthor(Long authorId) {
        return bookRepository.getBooksOfTheAuthor(authorId);
    }
}