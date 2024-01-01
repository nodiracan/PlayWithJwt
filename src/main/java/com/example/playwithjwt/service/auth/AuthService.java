package com.example.playwithjwt.service.auth;

import com.example.playwithjwt.dto.auth.AuthLoginDto;
import com.example.playwithjwt.dto.auth.AuthRegisterDto;
import com.example.playwithjwt.dto.auth.AuthUserDto;
import com.example.playwithjwt.dto.auth.SessionDto;
import com.example.playwithjwt.service.base.BaseService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

public interface AuthService extends BaseService {

    SessionDto login (AuthLoginDto dto);

    Integer register (AuthRegisterDto dto) throws BadRequestException;

    AuthUserDto get (Integer id);



}
