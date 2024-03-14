package org.nt_uni.web_studio.dao;

import org.nt_uni.web_studio.model.process.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByCodeIgnoreCase(String code);
}
