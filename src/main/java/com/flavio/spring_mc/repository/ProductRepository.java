package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
