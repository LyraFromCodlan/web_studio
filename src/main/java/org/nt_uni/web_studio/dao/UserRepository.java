package org.nt_uni.web_studio.dao;


import org.nt_uni.web_studio.model.base.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
