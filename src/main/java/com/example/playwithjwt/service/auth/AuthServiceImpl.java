package com.example.playwithjwt.service.auth;

import com.example.playwithjwt.configs.jwt.JwtService;
import com.example.playwithjwt.domains.AuthUser;
import com.example.playwithjwt.dto.auth.AuthLoginDto;
import com.example.playwithjwt.dto.auth.AuthRegisterDto;
import com.example.playwithjwt.dto.auth.AuthUserDto;
import com.example.playwithjwt.dto.auth.SessionDto;
import com.example.playwithjwt.mapper.AuthUserMapper;
import com.example.playwithjwt.repositories.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    private final AuthUserRepository authUserRepository;

    private final JwtService jwtService;
    private final AuthUserMapper authUserMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public SessionDto login(AuthLoginDto dto) {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );

        AuthUser authUser = authUserRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        return jwtService.createsessionDto(authUser);


    }

    @SneakyThrows
    @Override
    public Integer register(AuthRegisterDto dto){
        Optional<AuthUser> savedUser = authUserRepository.findByEmail(dto.getEmail());
        if (savedUser.isPresent()){
            throw new BadRequestException("This user already exists!!!");
        }

        AuthUser authUser = authUserMapper.fromRegisterDTO(dto);
        authUser.setRole(AuthUser.Role.USER);
        authUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        AuthUser saveUser = authUserRepository.save(authUser);
        return saveUser.getId();
    }

    @Override
    public AuthUserDto get(Integer id) {
        AuthUser user = authUserRepository.findById(id)
                .orElseThrow(
                        ()->new UsernameNotFoundException("User with this id not found"));

        return authUserMapper.toDTO(user);
    }
}
