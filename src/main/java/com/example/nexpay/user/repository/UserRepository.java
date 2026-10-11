package com.example.nexpay.user.repository;

import com.example.nexpay.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// JpaRepository<User, Long> tells Spring: "Connect this repository to the 'users' table (User entity), where the Primary Key type is Long (id)."
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data JPA sees this name and automatically writes the SQL:
    // "SELECT * FROM users WHERE email = ?"
    Optional<User> findByEmail(String email);

    // Spring Data JPA automatically writes the SQL:
    // "SELECT * FROM users WHERE phone = ?"
    Optional<User> findByPhone(String phone);

    // Spring Data JPA automatically writes the SQL:
    // "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM users WHERE email = ?"
    boolean existsByEmail(String email);

    // Spring Data JPA automatically writes the SQL:
    // "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM users WHERE phone = ?"
    boolean existsByPhone(String phone);
}
