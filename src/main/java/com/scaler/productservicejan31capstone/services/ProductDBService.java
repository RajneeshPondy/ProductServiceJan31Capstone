package com.scaler.productservicejan31capstone.services;

import com.scaler.productservicejan31capstone.exceptions.ProductNotFoundException;
import com.scaler.productservicejan31capstone.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productDBService")
public class ProductDBService implements ProductService {
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts(){
        return List.of();
    }

    @Override
    public Product createProduct(String name, double price, String description, String imageUrl, String category) {
        return null;
    }
}
