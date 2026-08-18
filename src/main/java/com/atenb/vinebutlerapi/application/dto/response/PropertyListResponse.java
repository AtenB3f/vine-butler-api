package com.atenb.vinebutlerapi.application.dto.response;

import java.math.BigDecimal;

public record PropertyListResponse(
        Long id,
        AddressResponse address,
        BigDecimal price,
        String propertyType,
        String[] tags
) {}
