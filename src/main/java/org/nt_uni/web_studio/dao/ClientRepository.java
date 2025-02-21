package org.nt_uni.web_studio.dao;

import org.nt_uni.web_studio.model.base.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByUsername(String username);
}
