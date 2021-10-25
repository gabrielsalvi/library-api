package com.gabrielsalvi.library.entity;

import java.time.LocalDate;

public class Author {

    private Long id;

    private String name;

    private String citizenship;

    private LocalDate birthdate;

    public Author() {}

    public Author(Long id, String name, String citizenship, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.citizenship = citizenship;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
