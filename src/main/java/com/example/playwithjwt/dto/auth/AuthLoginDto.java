package com.example.playwithjwt.dto.auth;

import com.example.playwithjwt.dto.base.BaseDto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthLoginDto implements BaseDto {

    private String email;
    private String password;

}
