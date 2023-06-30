package com.flavio.spring_mc.services;

import com.flavio.spring_mc.entities.models.Product;
import com.flavio.spring_mc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product insertProduct(Product prod){
        return productRepository.save(prod);
    }

    public Product findById(Integer id){
        Optional<Product> prodOpt = productRepository.findById(id);
        return new Product(prodOpt.get().getId(), prodOpt.get().getName(), prodOpt.get().getPrice());

    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
