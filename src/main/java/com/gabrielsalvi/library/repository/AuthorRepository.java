package com.gabrielsalvi.library.repository;

import com.gabrielsalvi.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
