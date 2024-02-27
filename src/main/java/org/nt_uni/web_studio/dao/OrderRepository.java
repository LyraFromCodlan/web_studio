package org.nt_uni.web_studio.dao;

import org.nt_uni.web_studio.model.base.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByCodeIgnoreCase(String code);
}
