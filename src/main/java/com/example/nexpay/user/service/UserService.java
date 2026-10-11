package com.example.nexpay.user.service;

import com.example.nexpay.security.JwtService;
import com.example.nexpay.user.dto.AuthResponse;
import com.example.nexpay.user.dto.LoginRequest;
import com.example.nexpay.user.dto.RegisterRequest;
import com.example.nexpay.user.model.User;
import com.example.nexpay.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;    // ← NEW: for generating tokens

    // ---- REGISTER (already existed) ----
    public User registerUser(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered!");
        }
        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone number is already registered!");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(User.Role.USER)
                .build();

        return userRepository.save(user);
    }

    // ---- LOGIN (NEW) ----
    public AuthResponse loginUser(LoginRequest request) {

        // Step 1: Find user by email
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // Step 2: Check password matches the BCrypt hash in DB
        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),    // what user typed: "secret123"
                user.getPasswordHash()    // what's in DB:   "$2a$10$xK8..."
        );

        if (!passwordMatches) {
            throw new RuntimeException("Invalid credentials!");
        }

        // Step 3: Generate JWT token
        String token = jwtService.generateToken(user.getEmail());

        // Step 4: Return token + user info
        return new AuthResponse(token, user.getEmail(), user.getFullName());
    }
}