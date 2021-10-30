package com.gabrielsalvi.library.controller;

import com.gabrielsalvi.library.entity.Genre;
import com.gabrielsalvi.library.repository.GenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    private GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre createGenre(@RequestBody @Valid Genre genre) {
        return genreRepository.save(genre);
    }
}
