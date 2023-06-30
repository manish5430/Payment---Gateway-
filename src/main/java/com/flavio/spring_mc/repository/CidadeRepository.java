package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<City, Integer> {
}
