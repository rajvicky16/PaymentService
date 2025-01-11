package com.ecommerce.paymentservice.payments;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("stripe")
public class StripePaymentLinkAdapter implements GeneratePaymentLinkAdapter {
    @Value("${stripe.api.key}")
    private String secretKey;

    @Override
    public String generatePaymentLink() {
        Stripe.apiKey = secretKey;

        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(1000L)
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
                        )
                        .build();

        Price price;
        try {
            price = Price.create(priceCreateParams);
        } catch (StripeException e) {
            throw new RuntimeException("Error while creating price object : " + e);
        }

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(10L)
                                        .build()
                        )
                        .build();



        PaymentLink paymentLink;
        try {
            paymentLink = PaymentLink.create(params);
        } catch (StripeException e) {
            throw new RuntimeException("Error while generating payment link " + e);
        }

        return paymentLink.getUrl();
    }
}
