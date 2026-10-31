package com.example.nexpay.wallet.repository;

import com.example.nexpay.wallet.model.Wallet;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    // 1. Standard non-locking read for balance inquiries
    Optional<Wallet> findByUserId(Long userId);

    // 2. Pessimistic Write Lock: Generates SELECT * FROM wallets WHERE user_id = ? FOR UPDATE
    // Acquires an exclusive row lock in PostgreSQL to prevent concurrent double-spending
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT w FROM Wallet w WHERE w.user.id = :userId")
    Optional<Wallet> findByUserIdWithLock(@Param("userId") Long userId);
}