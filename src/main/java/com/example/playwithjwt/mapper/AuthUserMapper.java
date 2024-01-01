package com.example.playwithjwt.mapper;

import com.example.playwithjwt.domains.AuthUser;
import com.example.playwithjwt.dto.auth.AuthRegisterDto;
import com.example.playwithjwt.dto.auth.AuthUserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper{

    AuthUser fromRegisterDTO(AuthRegisterDto dto);

    AuthUserDto toDTO(AuthUser user);
}
