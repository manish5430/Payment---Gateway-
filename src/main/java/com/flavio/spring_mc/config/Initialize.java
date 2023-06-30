package com.flavio.spring_mc.config;

import com.flavio.spring_mc.entities.models.*;
import com.flavio.spring_mc.enuns.TypeClient;
import com.flavio.spring_mc.repository.*;
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

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AddressRepository addressRepository;


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
        Product prod5 = new Product(null, "Scanner", 800.00);

        cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
        prod1.getCategories().add(cat1);
        prod2.getCategories().add(cat2);
        prod3.getCategories().add(cat4);
        prod4.getCategories().add(cat5);
        prod5.getCategories().add(cat1);

        State est1 = new State(null, "Minas Gerais");
        State est2 = new State(null, "São Paulo");

        City cid1 = new City(null, "Uberlândia", est1);
        City cid2 = new City(null, "São Paulo", est2);
        City cid3 = new City(null, "Campinas", est2);
        City cid4 = new City(null, "Diamantina", est1);

        est1.getCity().addAll(Arrays.asList(cid1, cid4));
        est2.getCity().addAll(Arrays.asList(cid2, cid3));

        estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4));

        repository.saveAll(categories);
        productRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4, prod5));

        Client cli1 = new Client(null, "Maria da Silva","maria@gmail.com", "12345678910", TypeClient.PESSOAFISICA);
        cli1.getPhones().addAll(Arrays.asList("12345678","98746541"));

        Address ad1 = new Address(null,
                "Rua Flores",
                "300",
                "Apto 303",
                "Jardim",
                "38220384",
                cli1, cid1
                );

        Address ad2 = new Address(null,
                "Rua Pitanga",
                "300",
                "Apto 300",
                "Jardim",
                "38220454",
                cli1, cid2
        );

        cli1.getAddresses().addAll(Arrays.asList(ad1, ad2));

        clientRepository.save(cli1);
        addressRepository.saveAll(Arrays.asList(ad1, ad2));
    }
}
