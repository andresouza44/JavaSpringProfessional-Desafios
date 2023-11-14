package com.devsuperior.desafio01order;

import com.devsuperior.desafio01order.entity.Order;
import com.devsuperior.desafio01order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class Desafio01OrderApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Desafio01OrderApplication.class, args);
    }

    @Autowired
    OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        Order order1 = new Order(1034, 150d, 20d);
        Order order2 = new Order(2282, 800d, 10d);
        Order order3 = new Order(1309, 95.9d, 0d);

        System.out.println("Pedido código " + order1.getCode());
        System.out.printf("Valor total R$: %.2f", orderService.total(order1));
        System.out.println("\n________________________________\n");

        System.out.println("Pedido código " + order2.getCode());
        System.out.printf("Valor total R$: %.2f", orderService.total(order2));
        System.out.println("\n________________________________\n");

        System.out.println("Pedido código " + order3.getCode());
        System.out.printf("Valor total R$: %.2f", orderService.total(order3));
        System.out.println("\n________________________________\n");
    }
}
