package com.example.OrderService.config;

import com.example.OrderService.exception.decoder.CustomDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DecoderConfig {
    @Bean
    public ErrorDecoder CreateConfig(){
        return new CustomDecoder();
    }
}
