package com.example.OrderService.exception.decoder;

import com.example.OrderService.exception.OrderServiceCustomException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.web.ErrorResponse;

import java.io.IOException;

public class CustomDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            com.example.OrderService.exception.ErrorResponse errorResponse = (com.example.OrderService.exception.ErrorResponse) objectMapper.readValue(response.body().asInputStream(),ErrorResponse.class);
            return new OrderServiceCustomException(errorResponse.getMessage(),errorResponse.getErrorCode());
        } catch (IOException e) {
           e.printStackTrace();
        }
        return new OrderServiceCustomException("INTERNALSERVICE Exception","SERVICE_EXCEPTION");
    }
}
