package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
