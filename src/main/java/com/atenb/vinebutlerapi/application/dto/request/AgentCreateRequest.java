package com.atenb.vinebutlerapi.application.dto.request;

public record AgentCreateRequest(
        String name,
        String phone,
        String companyName
) {
}
