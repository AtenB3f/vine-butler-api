package com.atenb.vinebutlerapi.application.dto.request;

import java.time.LocalDate;
import java.util.List;

public record PropertyCreateRequest(
        AddressCreateRequest address,
        PropertyTransactionCreateRequest transaction,
        AgentCreateRequest agent,
        String propertyType,
        String ownerPhoneNumber,
        Boolean isLoan,
        Boolean moveInAvailable,
        LocalDate moveInDate,
        Boolean parkingAvailable,
        String memo,
        List<Long> furnitureOptionIds
) {
}
