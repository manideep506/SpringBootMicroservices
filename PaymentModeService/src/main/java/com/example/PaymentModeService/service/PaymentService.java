package com.example.PaymentModeService.service;

import com.example.PaymentModeService.model.PaymentRequest;

public interface PaymentService {

    long doPayment(PaymentRequest paymentRequest);
}
