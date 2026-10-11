package com.example.nexpay.user.controller;

import com.example.nexpay.user.dto.RegisterRequest;
import com.example.nexpay.user.model.User;
import com.example.nexpay.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // POST /api/auth/register
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        User registeredUser = userService.registerUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully! ID: " + registeredUser.getId());
    }
}
