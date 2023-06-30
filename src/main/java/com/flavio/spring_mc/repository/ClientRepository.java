package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
