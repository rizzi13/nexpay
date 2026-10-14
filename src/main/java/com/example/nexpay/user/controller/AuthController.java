package com.example.nexpay.user.controller;

import com.example.nexpay.user.dto.AuthResponse;
import com.example.nexpay.user.dto.LoginRequest;
import com.example.nexpay.user.dto.RegisterRequest;
import com.example.nexpay.user.model.User;
import com.example.nexpay.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        User registeredUser = userService.registerUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully! ID: " + registeredUser.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}
