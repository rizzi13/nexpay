package com.example.nexpay.wallet.controller;

import com.example.nexpay.wallet.dto.TopUpRequest;
import com.example.nexpay.wallet.dto.WalletResponse;
import com.example.nexpay.wallet.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/balance")
    public ResponseEntity<WalletResponse> getBalance(Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok(walletService.getBalance(email));
    }

    @PostMapping("/top-up")
    public ResponseEntity<WalletResponse> topUp(
            Authentication authentication,
            @Valid @RequestBody TopUpRequest request
    ) {
        String email = authentication.getName();
        return ResponseEntity.ok(walletService.topUp(email, request.getAmount()));
    }
}
