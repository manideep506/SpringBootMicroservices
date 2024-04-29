package com.example.PaymentModeService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Table_PaymentDetails")
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;
    private long orderId;
    private Instant paymentDate;
    private String paymentMode;
    private String paymentStatus;

    private double amount;
}
