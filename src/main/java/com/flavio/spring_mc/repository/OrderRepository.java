package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
