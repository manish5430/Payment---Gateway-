package com.flavio.spring_mc.config;

import com.flavio.spring_mc.entities.enums.StatusPayment;
import com.flavio.spring_mc.entities.models.*;
import com.flavio.spring_mc.entities.enums.TypeClient;
import com.flavio.spring_mc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;


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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Order order1 = new Order(null, sdf.parse("30/09/2017 10:30").toInstant(), cli1, ad1);
        Order order2 = new Order(null, sdf.parse("01/10/2017 11:40").toInstant(), cli1, ad2);

        Payment pay1 = new PaymentWithCard(null, StatusPayment.PAID, order1, 6);
        order1.setPayment(pay1);

        Payment pay2 = new PaymentWithTicket(null, StatusPayment.PENDING, order2, sdf.parse("20/10/2017 00:00").toInstant(), null);
        order2.setPayment(pay2);

        cli1.getOrders().addAll(Arrays.asList(order1, order2));

        orderRepository.saveAll(Arrays.asList(order1, order2));
        paymentRepository.saveAll(Arrays.asList(pay1, pay2));

        OrderItem orderItem1 = new OrderItem(order1, prod1, 0.0, 1,2000.00 );
        OrderItem orderItem2 = new OrderItem(order1, prod3, 0.0, 2,80.00 );
        OrderItem orderItem3 = new OrderItem(order2, prod2, 100.0, 1,800.00 );

        order1.getOrderItems().addAll(Arrays.asList(orderItem1, orderItem2));
        order2.getOrderItems().add(orderItem3);

        prod1.getOrderItems().add(orderItem1);
        prod2.getOrderItems().add(orderItem3);
        prod3.getOrderItems().add(orderItem2);

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3));




    }
}
