package com.atenb.vinebutlerapi.application.dto.request;

import java.math.BigDecimal;

public record PropertyTransactionCreateRequest(
        String transactionType,
        BigDecimal transactionAmount,
        BigDecimal monthlyRent,
        BigDecimal maintenanceCost
) {
}
