package com.gabrielsalvi.library.repository;

import com.gabrielsalvi.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
