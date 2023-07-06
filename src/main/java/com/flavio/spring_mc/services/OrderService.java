package com.flavio.spring_mc.services;

import com.flavio.spring_mc.entities.models.Order;
import com.flavio.spring_mc.repository.OrderRepository;
import com.flavio.spring_mc.services.exceptions.ObjectNotFoundExcepetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order findById(Integer id){
        Optional<Order> orderOpt = orderRepository.findById(id);
        return orderOpt.orElseThrow(() -> new ObjectNotFoundExcepetion("Object not found"));
    }
}
