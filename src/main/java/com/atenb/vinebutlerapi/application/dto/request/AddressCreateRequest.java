package com.atenb.vinebutlerapi.application.dto.request;

import java.math.BigDecimal;

public record AddressCreateRequest(
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
