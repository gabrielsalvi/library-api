package com.gabrielsalvi.library.repository;

import com.gabrielsalvi.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book INNER JOIN book_authors ON (book.id = book_authors.book_id) WHERE book_authors.authors_id = ?", nativeQuery = true)
    List<Book> getBooksOfTheAuthor(Long id);
}
