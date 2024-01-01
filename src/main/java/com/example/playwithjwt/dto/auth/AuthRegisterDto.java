package com.example.playwithjwt.dto.auth;

import com.example.playwithjwt.dto.base.BaseDto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthRegisterDto implements BaseDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
