package com.example.OrderService.service;

import com.ctc.wstx.util.StringUtil;
import com.example.OrderService.client.PaymentService;
import com.example.OrderService.client.ProductService;
import com.example.OrderService.entity.Order;
import com.example.OrderService.model.OrderRequest;
import com.example.OrderService.model.PaymentRequest;
import com.example.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ProductService productService;

    @Override
    public Long placeOrder(OrderRequest orderRequest) {
        log.info("before placing order");
        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());
        log.info("after checking product availability"+ orderRequest.getProductId());
        Order order= Order.builder()
                .productId(orderRequest.getProductId())
                .price(orderRequest.getAmount())
                .orderDate(Instant.now())
                .orderStatus("CREATED")
                .quantity(orderRequest.getQuantity())
                .build();
        log.info("order placed");
        order =orderRepository.save(order);
        log.info("product saved successfully after placing order");

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .amount (orderRequest.getAmount())
                .paymentMode (orderRequest.getPaymentMode())
                .orderId (order.getOrderId())
                .build();
        log.info("paymentRequest 55 "+paymentRequest);
        String status = StringUtils.EMPTY;
        try{
            paymentService.doPayment(paymentRequest);
            status = "Success";
        }catch (Exception e){
            log.info("payment failed" +paymentRequest);
            status = "Failed";
        }
        order.setOrderStatus(status);
        order = orderRepository.save(order);
        log.info("order was suceesfull ");
        return order.getOrderId();
    }
}
