package com.example.playwithjwt.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SessionDto {

    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long accessTokenExpire;
    private Long issuedAt;
    private Long expiresIn;
}
