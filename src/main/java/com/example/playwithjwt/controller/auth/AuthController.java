package com.example.playwithjwt.controller.auth;

import com.example.playwithjwt.controller.base.AbstractController;
import com.example.playwithjwt.dto.auth.AuthLoginDto;
import com.example.playwithjwt.dto.auth.AuthRegisterDto;
import com.example.playwithjwt.dto.auth.SessionDto;
import com.example.playwithjwt.service.auth.AuthServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController extends AbstractController<AuthServiceImpl> {

    public AuthController(AuthServiceImpl service) {
        super(service);
    }

    @PostMapping(value = PATH + "/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessionDto> login(@RequestBody AuthLoginDto dto){
        return ResponseEntity.ok(
                service.login(dto)
        );
    }

    @PostMapping(value = PATH + "/auth/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Integer> register(@RequestBody AuthRegisterDto dto){
        return ResponseEntity.ok(
                service.register(dto)
        );
    }

}
