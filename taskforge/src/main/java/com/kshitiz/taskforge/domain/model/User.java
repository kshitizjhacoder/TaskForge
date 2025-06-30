package com.kshitiz.taskforge.domain.model;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final String email;
    private final String role; 

    public User(UUID id, String name, String email, String role) {
        this.id = id != null ? id : UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Factory method for creation without predefined ID
    public static User create(String name, String email, String role) {
        return new User(UUID.randomUUID(), name, email, role);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean isAdmin() {
        return "ADMIN".equalsIgnoreCase(role);
    }

    public boolean isUser() {
        return "USER".equalsIgnoreCase(role);
    }
}
