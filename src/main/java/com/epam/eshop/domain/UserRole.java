package com.epam.eshop.domain;

public enum UserRole {

    ADMIN(0, "Admin"),
    CLIENT(1, "Client");

    private int id;
    private String name;

    UserRole(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
