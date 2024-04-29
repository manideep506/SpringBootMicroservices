package com.example.PaymentModeService.repository;

import com.example.PaymentModeService.entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDetails,Long> {
}
