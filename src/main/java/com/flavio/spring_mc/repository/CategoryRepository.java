package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
