package com.atenb.vinebutlerapi.application.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PropertySearchRequest(
        String keyword,
        String propertyType,
        String transactionType,
        BigDecimal price,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        String room,
        Boolean parkingAvailable,
        Boolean isLoan,
        Boolean isSuretyInsured,
        String sourceType,
        LocalDate moveInDate
) {
}
