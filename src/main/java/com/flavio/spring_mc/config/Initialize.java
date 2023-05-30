package com.flavio.spring_mc.config;

import com.flavio.spring_mc.entities.models.Category;
import com.flavio.spring_mc.entities.models.Product;
import com.flavio.spring_mc.repository.CategoryRepository;
import com.flavio.spring_mc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class Initialize implements CommandLineRunner {

    @Autowired
    CategoryRepository repository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(1, "Informática");
        Category cat2 = new Category(2, "Marketing");
        Category cat3 = new Category(3, "Produção");
        Category cat4 = new Category(4, "Desenvolvimento");
        Category cat5 = new Category(5, "Infra");

        ArrayList<Category> categories = new ArrayList<>(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

        repository.saveAll(categories);

        Product prod1 = new Product(null, "Impressora", 1256.00);
        Product prod2 = new Product(null, "Banner", 1256.00);
        Product prod3 = new Product(null, "Curso de Lógica", 1256.00);
        Product prod4 = new Product(null, "Cabo de rede", 1256.00);

        cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3, prod4));
        prod1.getCategories().add(cat1);
        prod2.getCategories().add(cat2);
        prod3.getCategories().add(cat4);
        prod4.getCategories().add(cat5);

        repository.saveAll(categories);
        productRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4));

    }
}
