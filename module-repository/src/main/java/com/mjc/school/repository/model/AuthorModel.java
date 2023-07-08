package com.mjc.school.repository.model;

public class AuthorModel {

    private final Long id;

    private final String name;

    public AuthorModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
