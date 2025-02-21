package org.nt_uni.web_studio.dao;

import org.nt_uni.web_studio.model.base.ApplicationType;
import org.nt_uni.web_studio.model.base.Order;
import org.nt_uni.web_studio.model.base.SoftwareType;
import org.nt_uni.web_studio.model.process.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByCodeIgnoreCase(String code);
    List<Order> findAllByApplicationType(ApplicationType applicationType);
    List<Order> findAllBySoftwareType(SoftwareType softwareType);
    List<Order> findAllByStatus(Status status);
}
