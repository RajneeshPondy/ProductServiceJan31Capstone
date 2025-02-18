package com.scaler.productservicejan31capstone.controllers;

import com.scaler.productservicejan31capstone.dtos.CreateFakeStoreProductDto;
import com.scaler.productservicejan31capstone.dtos.ProductResponseDto;
import com.scaler.productservicejan31capstone.exceptions.ProductNotFoundException;
import com.scaler.productservicejan31capstone.models.Product;
import com.scaler.productservicejan31capstone.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        ProductResponseDto productResponseDto = ProductResponseDto.from(product);
        return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() throws ProductNotFoundException {
       List<Product> products = productService.getAllProducts();

       List<ProductResponseDto> productResponseDtos = new ArrayList<>();
       for (Product product : products) {
           ProductResponseDto productResponseDto = ProductResponseDto.from(product);
           productResponseDtos.add(productResponseDto);
       }
//       List<ProductResponseDto> productResponseDtos =
//               products.stream().map(ProductResponseDto::from).toList();
       return productResponseDtos;
    }

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody CreateFakeStoreProductDto createFakeStoreProductDto){
        Product product = productService.createProduct(
                createFakeStoreProductDto.getName(),
                createFakeStoreProductDto.getPrice(),
                createFakeStoreProductDto.getDescription(),
                createFakeStoreProductDto.getImageUrl(),
                createFakeStoreProductDto.getCategory());

        ProductResponseDto productResponseDto = ProductResponseDto.from(product);
        return productResponseDto;
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ErrorDto handleNullPointerException(){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setStatus("Failure");
//        errorDto.setMessage("Product not found");
//        return errorDto;
//    }
}