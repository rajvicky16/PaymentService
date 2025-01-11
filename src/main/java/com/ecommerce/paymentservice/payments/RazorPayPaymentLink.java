package com.ecommerce.paymentservice.payments;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component("razorpay")
public class RazorPayPaymentLink implements GeneratePaymentLinkAdapter {
    RazorpayClient razorpayClient;

    public RazorPayPaymentLink(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("amount", 5000);
        jsonObject.put("currency", "INR");
        jsonObject.put("accept_partial", false);
        //jsonObject.put("expire_by", 1625457600);
        jsonObject.put("reference_id", "12354363");
        jsonObject.put("description", "Acme Order #1234");
        jsonObject.put("customer", new JSONObject().put("name", "Test Name").put("contact", "+91234234234").put("email", "abcdedge@gmail.com"));
        jsonObject.put("notify", new JSONObject().put("sms", true).put("email", true));
        jsonObject.put("reminder_enable", true);
        jsonObject.put("notes", new JSONObject().put("policy_name", "Jeevan Bima"));
        jsonObject.put("callback_url", "https://google.com/");
        jsonObject.put("callback_method", "get");

        PaymentLink paymentLink;
        try {
            paymentLink = razorpayClient.paymentLink.create(jsonObject);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }

        return paymentLink.get("short_url");
    }
}
