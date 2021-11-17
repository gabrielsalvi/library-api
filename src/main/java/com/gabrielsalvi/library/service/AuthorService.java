package com.gabrielsalvi.library.service;

import com.gabrielsalvi.library.entity.Author;
import com.gabrielsalvi.library.exception.AuthorNotFoundException;
import com.gabrielsalvi.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) throws AuthorNotFoundException {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }

    public Author update(Long id, Author author) throws AuthorNotFoundException {
        Author authorToUpdate = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        authorToUpdate.setName(author.getName());
        authorToUpdate.setBirthdate(author.getBirthdate());
        authorToUpdate.setCitizenship(author.getCitizenship());

        authorRepository.save(authorToUpdate);

        return authorToUpdate;
    }

    public void delete(Long id) throws AuthorNotFoundException {
        Author authorToDelete = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        authorRepository.delete(authorToDelete);
    }
}