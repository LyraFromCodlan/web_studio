package org.nt_uni.web_studio.dao;

import org.nt_uni.web_studio.model.process.BusinessProcessStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<BusinessProcessStage, Long> {
}
