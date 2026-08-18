package com.atenb.vinebutlerapi.application.dto.response;

import java.math.BigDecimal;

public record PropertyTransactionResponse(
        String transactionType,
        String transactionStatus,
        BigDecimal transactionAmount,
        BigDecimal monthlyRent,
        BigDecimal maintenanceCost
) {
}