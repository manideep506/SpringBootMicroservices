package com.example.ProductService.service;

import com.example.ProductService.entity.Product;
import com.example.ProductService.exception.ProductServiceException;
import com.example.ProductService.model.ProductRequest;
import com.example.ProductService.model.ProductResponse;
import com.example.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Long addProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                        .productName(productRequest.getProductName())
                                .price(productRequest.getPrice())
                                        .quantity(productRequest.getQuantity())
                                                .build();
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(Long productId) throws ProductServiceException {
        Product product= productRepository.findById(productId)
                .orElseThrow(()-> new ProductServiceException("Product id not Found","Product_Not_Found"));
        ProductResponse productResponse = ProductResponse.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();

        return productResponse;
    }

    @Override
    public void reduceQuantity(Long productId, int quantity) throws ProductServiceException {
        log.info("reducing quantity initiated");
        Product product= productRepository.findById(productId)
                .orElseThrow(()-> new ProductServiceException("Product id not Found","Product_Not_Found"));

        if(product instanceof Product){
            log.info("checking product quantity");
            if(product.getQuantity()< quantity){
                throw new ProductServiceException("not having enough quantity of products","NOT_ENOUGH_Quantity");
            }
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
            log.info("saved in DB");
        }

    }
}
