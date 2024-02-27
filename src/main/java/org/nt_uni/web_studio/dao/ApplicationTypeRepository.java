package org.nt_uni.web_studio.dao;

import org.nt_uni.web_studio.model.base.ApplicationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationTypeRepository extends JpaRepository<ApplicationType, Long> {
    ApplicationType findByCodeIgnoreCase(String code);
}
