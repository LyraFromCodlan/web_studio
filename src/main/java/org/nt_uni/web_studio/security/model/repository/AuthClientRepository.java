package org.nt_uni.web_studio.security.model.repository;

import org.nt_uni.web_studio.security.model.AuthClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthClientRepository extends JpaRepository<AuthClient, Integer> {
    Optional<AuthClient> findByUsername(String username);
}
