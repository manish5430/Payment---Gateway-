package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<State, Integer> {
}
