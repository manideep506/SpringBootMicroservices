package com.example.PaymentModeService.controller;

import com.example.PaymentModeService.model.PaymentRequest;
import com.example.PaymentModeService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
        long paymentId = paymentService.doPayment(paymentRequest);
        return new ResponseEntity<Long>(paymentId, HttpStatus.OK);
    }

}
