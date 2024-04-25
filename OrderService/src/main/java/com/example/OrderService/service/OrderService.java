package com.example.OrderService.service;

import com.example.OrderService.model.OrderRequest;
import com.example.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);
}
