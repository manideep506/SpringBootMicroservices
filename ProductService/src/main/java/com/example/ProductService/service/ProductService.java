package com.example.ProductService.service;

import com.example.ProductService.exception.ProductServiceException;
import com.example.ProductService.model.ProductRequest;
import com.example.ProductService.model.ProductResponse;

public interface ProductService {
    Long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long productId) throws ProductServiceException;

    void reduceQuantity(Long productId, int quantity) throws ProductServiceException;
}
