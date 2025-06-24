package com.platform.ecommerce.config;

import com.platform.ecommerce.model.Product;
import com.platform.ecommerce.model.User;
import com.platform.ecommerce.repository.ProductRepository;
import com.platform.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            productRepository.save(new Product("Laptop", 75000));
            productRepository.save(new Product("Smartphone", 30000));
            productRepository.save(new Product("Headphones", 2500));
        }

        if (userRepository.count() == 0) {
            userRepository.save(new User(null, "Alice"));
            userRepository.save(new User(null, "Bob"));
        }

        System.out.println("Dummy data seeded.");
    }
}
