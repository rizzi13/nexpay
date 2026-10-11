package com.example.nexpay.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")   // This creates a table named "users" in PostgreSQL
@Data                    // Lombok: Auto-creates getters, setters, toString()
@Builder                 // Lombok: Allows clean object creation (e.g. User.builder().build())
@NoArgsConstructor       // Lombok: Auto-creates empty constructor (JPA requirement)
@AllArgsConstructor      // Lombok: Auto-creates constructor with all fields
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increments id (1, 2, 3...)
    private Long id;

    @NotBlank(message = "Full name is required")
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @Column(unique = true, nullable = false)  // No two users can have the same email
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;              // We will save hashed password here for security

    @Column(unique = true)
    private String phone;                     // Phone number for P2P transfers

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;           // Roles (e.g. USER, ADMIN)

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist  // This method runs automatically before we insert a new user row in the database
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public enum Role {
        USER, ADMIN
    }
}
