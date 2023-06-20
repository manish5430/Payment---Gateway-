package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
