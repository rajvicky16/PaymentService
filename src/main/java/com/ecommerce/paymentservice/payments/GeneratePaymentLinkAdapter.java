package com.ecommerce.paymentservice.payments;

import org.springframework.stereotype.Component;

@Component
public interface GeneratePaymentLinkAdapter {
    String generatePaymentLink();
}
