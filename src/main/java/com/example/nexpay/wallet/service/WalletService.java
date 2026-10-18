package com.example.nexpay.wallet.service;

import com.example.nexpay.user.model.User;
import com.example.nexpay.user.repository.UserRepository;
import com.example.nexpay.wallet.dto.WalletResponse;
import com.example.nexpay.wallet.model.Wallet;
import com.example.nexpay.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;

    public WalletResponse getBalance(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Wallet wallet = walletRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Wallet not found!"));

        return WalletResponse.builder()
                .balance(wallet.getBalance())
                .currency(wallet.getCurrency())
                .updatedAt(wallet.getUpdatedAt())
                .build();
    }

    @Transactional
    public WalletResponse topUp(String email, BigDecimal amount) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Wallet wallet = walletRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Wallet not found!"));

        wallet.setBalance(wallet.getBalance().add(amount));
        Wallet savedWallet = walletRepository.save(wallet);

        return WalletResponse.builder()
                .balance(savedWallet.getBalance())
                .currency(savedWallet.getCurrency())
                .updatedAt(savedWallet.getUpdatedAt())
                .build();
    }
}
