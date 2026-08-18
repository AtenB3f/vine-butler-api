package com.atenb.vinebutlerapi.application.dto.response;

import java.math.BigDecimal;

public record BuildingResponse(
        Integer floor,
        Integer totalFloor,
        String propertyTypeCode,
        BigDecimal exclusiveArea,
        BigDecimal supplyArea,
        BigDecimal commonArea,
        BigDecimal rentableArea
) {
}
