package com.atenb.vinebutlerapi.application.dto.response;

import com.atenb.vinebutlerapi.domain.entity.*;

import java.util.List;

public record PropertyDetailResponse(
        Long id,
        List<String> imageUrls,
        AddressResponse address,
        AgentResponse agent,
        String propertyType,
        PropertyTransactionResponse propertyTransaction,
        String ownerPhoneNumber,
        BuildingResponse buildingInfo,
        Boolean isLoan,
        Boolean isSuretyInsured,
        Boolean moveInAvailable,
        Boolean parkingAvailable,
        List<String> furnitureOptions,
        String sourceUrl,
        String sourceType,
        String memo,
        String blogPostUrl
) {

}
