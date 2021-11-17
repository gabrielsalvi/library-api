package com.gabrielsalvi.library.service;

import com.gabrielsalvi.library.entity.Genre;
import com.gabrielsalvi.library.exception.GenreNotFoundException;
import com.gabrielsalvi.library.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    public List<Genre> listAll() {
        return genreRepository.findAll();
    }

    public Genre findById(Long id) throws GenreNotFoundException {
        return genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id));
    }

    public void update(Long id, Genre genre) throws GenreNotFoundException{
        Genre genreToUpdate = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id));

        genreToUpdate.setGenre(genre.getGenre());
        genreToUpdate.setDescription(genre.getDescription());

        genreRepository.save(genreToUpdate);
    }

    public void deleteById(Long id) throws GenreNotFoundException{
        Genre genreToDelete = genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id));

        genreRepository.delete(genreToDelete);
    }
}