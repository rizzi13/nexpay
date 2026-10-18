package com.example.nexpay.wallet.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TopUpRequest {

    @NotNull(message = "Top-up amount is required")
    @DecimalMin(value = "1.0000", message = "Top-up amount must be at least ₹1.00")
    private BigDecimal amount;
}
