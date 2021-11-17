package com.gabrielsalvi.library.controller;

import com.gabrielsalvi.library.entity.Genre;
import com.gabrielsalvi.library.exception.GenreNotFoundException;
import com.gabrielsalvi.library.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre createGenre(@RequestBody @Valid Genre genre) {
        return genreService.create(genre);
    }

    @GetMapping
    public List<Genre> listGenres() {
        return genreService.listAll();
    }

    @GetMapping("/{id}")
    public Genre findById(@PathVariable Long id) throws GenreNotFoundException{
        return genreService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable Long id, @RequestBody @Valid Genre genre) throws GenreNotFoundException{
        genreService.update(id, genre);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws GenreNotFoundException{
        genreService.deleteById(id);
    }
}