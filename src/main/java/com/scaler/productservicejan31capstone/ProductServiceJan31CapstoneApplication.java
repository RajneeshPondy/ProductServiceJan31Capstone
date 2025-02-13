package com.scaler.productservicejan31capstone;

import com.scaler.productservicejan31capstone.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceJan31CapstoneApplication {

    public static void main(String[] args) {
        Product product = new Product();
        SpringApplication.run(ProductServiceJan31CapstoneApplication.class, args);
    }

}
