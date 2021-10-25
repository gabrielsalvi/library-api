package com.gabrielsalvi.library.entity;

public class Genre {

    private Long id;

    private String genre;

    private String description;

    public Genre() {}

    public Genre(Long id, String genre, String description) {
        this.id = id;
        this.genre = genre;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}