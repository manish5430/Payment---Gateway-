package com.flavio.spring_mc.resources;

import com.flavio.spring_mc.entities.models.Category;
import com.flavio.spring_mc.entities.models.Order;
import com.flavio.spring_mc.services.CategoryService;
import com.flavio.spring_mc.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> find(@PathVariable Integer id) {
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
