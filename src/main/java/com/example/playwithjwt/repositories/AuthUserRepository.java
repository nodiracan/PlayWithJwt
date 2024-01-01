package com.example.playwithjwt.repositories;

import com.example.playwithjwt.domains.AuthUser;
import com.example.playwithjwt.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer>, BaseRepository {

    Optional<AuthUser> findByEmail (String email);

}
