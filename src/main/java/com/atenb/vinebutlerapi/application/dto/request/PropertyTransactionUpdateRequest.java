package com.atenb.vinebutlerapi.application.dto.request;

import java.math.BigDecimal;

public record PropertyTransactionUpdateRequest(
        String transactionType,
        String transactionStatus,
        BigDecimal transactionAmount,
        BigDecimal monthlyRent,
        BigDecimal maintenanceCost
) {
}
