package com.atenb.vinebutlerapi.application.dto.response;

import java.math.BigDecimal;

public record AddressResponse(
        String sidoName,
        String sigunguName,
        String eupMyeonDongName,
        String jibunAddr,
        String roadAddr,
        String zipCode,
        BigDecimal latitude,
        BigDecimal longitude
) {
}
