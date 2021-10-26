package com.gabrielsalvi.library.repository;

import com.gabrielsalvi.library.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}