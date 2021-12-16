package com.example.reto5;

import com.example.reto5.repositories.interfaces.OrderInterface;
import com.example.reto5.repositories.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import com.example.reto5.repositories.interfaces.ProductInterface;

@Component
@SpringBootApplication
public class Reto5C4 implements CommandLineRunner {

    @Autowired
    private OrderInterface orderInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private ProductInterface supplementsInterface;

    public static void main(String[] args) {
        SpringApplication.run(Reto5C4.class, args);
    }

	@Override
    public void run(String... args) throws Exception {
        supplementsInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
    }
}