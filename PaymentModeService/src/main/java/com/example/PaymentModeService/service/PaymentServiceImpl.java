package com.example.PaymentModeService.service;

import com.example.PaymentModeService.entity.PaymentDetails;
import com.example.PaymentModeService.model.PaymentRequest;
import com.example.PaymentModeService.repository.PaymentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("paymentRequest in paymentserviceImpl::"+ paymentRequest);
        PaymentDetails paymentDetails= PaymentDetails.builder()
                .amount(paymentRequest.getAmount())
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("success")
                .orderId(paymentRequest.getOrderId())
                .build();
        log.info("paymentDetails in do payment" +paymentDetails);
        paymentRepository.save(paymentDetails);
        return paymentDetails.getPaymentId();
    }
}
