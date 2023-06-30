package com.flavio.spring_mc.resources;


import com.flavio.spring_mc.entities.models.Product;
import com.flavio.spring_mc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> find(@PathVariable Integer id) {
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Product> inserCategory(@RequestBody Product product) {
        Product obj = productService.insertProduct(product);
        return ResponseEntity.ok().body(obj);
    }
}
