package com.example.ProductService.service;

import com.example.ProductService.entity.Product;
import com.example.ProductService.exception.ProductServiceException;
import com.example.ProductService.model.ProductRequest;
import com.example.ProductService.model.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long productId) throws ProductServiceException;

    void reduceQuantity(Long productId, int quantity) throws ProductServiceException;

    ResponseEntity<List<Product>> getProducts();

    void deleteProductById(Long productId);
}
