package com.epam.eshop.domain;

public enum UserRole {

    ADMIN(1, "Admin"),
    CLIENT(2, "Client");

    private int id;
    private String name;

    UserRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
