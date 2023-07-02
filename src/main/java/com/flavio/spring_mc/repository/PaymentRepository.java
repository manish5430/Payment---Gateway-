package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
