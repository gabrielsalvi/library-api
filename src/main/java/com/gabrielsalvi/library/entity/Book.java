package com.gabrielsalvi.library.entity;

public class Book {

    private Long id;

    private String title;

    private Author author;

    private Genre genre;

    private int pages;

    public Book() {}

    public Book(Long id, String title, Author author, Genre genre, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}