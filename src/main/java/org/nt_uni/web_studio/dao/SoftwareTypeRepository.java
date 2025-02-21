package org.nt_uni.web_studio.dao;

import org.nt_uni.web_studio.model.base.SoftwareType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareTypeRepository extends JpaRepository<SoftwareType, String> {
    SoftwareType findByCodeIgnoreCase(String code);
}
