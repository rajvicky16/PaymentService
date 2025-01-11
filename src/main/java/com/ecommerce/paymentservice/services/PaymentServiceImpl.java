package com.ecommerce.paymentservice.services;

import com.ecommerce.paymentservice.payments.GeneratePaymentLinkAdapter;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    GeneratePaymentLinkAdapter generatePaymentLinkAdapter;

    public PaymentServiceImpl(GeneratePaymentLinkAdapter generatePaymentLinkAdapter){
        this.generatePaymentLinkAdapter = generatePaymentLinkAdapter;
    }

    @Override
    public String pay() {
        return generatePaymentLinkAdapter.generatePaymentLink();
    }
}
