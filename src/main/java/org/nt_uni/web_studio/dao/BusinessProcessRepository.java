package org.nt_uni.web_studio.dao;

import org.nt_uni.web_studio.model.process.BusinessProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessProcessRepository extends JpaRepository<BusinessProcess, Long> {
}
