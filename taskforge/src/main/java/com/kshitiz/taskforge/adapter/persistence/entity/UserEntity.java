package com.kshitiz.taskforge.adapter.persistence.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tbl_User")
public class UserEntity {

    @Id
    @Column(name = "userId", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "userName", nullable = false)
    private String name;

    @Column(name = "userEmail", nullable = false, unique = true)
    private String email;

    @Column(name = "userRole", nullable = false)
    private String role;

    // --- Constructors ---

    protected UserEntity() {
        // JPA default constructor
    }

    public UserEntity(UUID id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // --- Getters and Setters ---

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
