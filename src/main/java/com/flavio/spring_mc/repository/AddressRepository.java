package com.flavio.spring_mc.repository;

import com.flavio.spring_mc.entities.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
