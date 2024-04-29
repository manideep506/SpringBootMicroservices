package com.example.ProductService.controller;

import com.example.ProductService.entity.Product;
import com.example.ProductService.exception.ProductServiceException;
import com.example.ProductService.model.ProductRequest;
import com.example.ProductService.model.ProductResponse;
import com.example.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllQuestions(){
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        Long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long productId) throws ProductServiceException {
        ProductResponse response = productService.getProductById(productId);
        return new ResponseEntity<ProductResponse>(response,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) throws ProductServiceException {
        productService.deleteProductById(productId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable ("id") Long productId, @RequestParam int quantity) throws ProductServiceException {
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
