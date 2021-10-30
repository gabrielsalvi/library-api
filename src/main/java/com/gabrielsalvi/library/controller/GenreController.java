package com.gabrielsalvi.library.controller;

import com.gabrielsalvi.library.entity.Genre;
import com.gabrielsalvi.library.exception.GenreNotFoundException;
import com.gabrielsalvi.library.repository.GenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/genres")
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

    @GetMapping
    public List<Genre> listGenres() {
        return genreRepository.findAll();
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable Long id, @RequestBody @Valid Genre genre) throws GenreNotFoundException{
        Genre genreToUpdate = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id));

        genreToUpdate.setGenre(genre.getGenre());
        genreToUpdate.setDescription(genre.getDescription());

        genreRepository.save(genreToUpdate);
    }
}
