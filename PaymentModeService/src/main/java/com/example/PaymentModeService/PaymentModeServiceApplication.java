package com.example.PaymentModeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class PaymentModeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentModeServiceApplication.class, args);
	}

}
