package org.nt_uni.web_studio.security.model.repository;

import org.nt_uni.web_studio.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
