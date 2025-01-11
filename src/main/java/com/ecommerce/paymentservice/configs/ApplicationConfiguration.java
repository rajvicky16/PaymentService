package com.ecommerce.paymentservice.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Value("${razorpay.api.key}")
    private String razorPayApiKey;
    @Value("${razorpay.api.secret}")
    private String razorPaySecretKey;

    @Bean
    public RazorpayClient createRazorpayClient() {
        RazorpayClient razorpayClient;
        try {
            razorpayClient = new RazorpayClient(razorPayApiKey, razorPaySecretKey);
        } catch (RazorpayException e) {
            throw new RuntimeException("Error while creating RazorpayClient Bean : " + e);
        }
        return razorpayClient;
    }
}
