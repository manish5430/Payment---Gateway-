package com.flavio.spring_mc.controllers;
import com.flavio.spring_mc.services.PayPalService;
import com.paypal.api.payments.Payment;

import jakarta.servlet.http.HttpServletResponse;

import com.paypal.api.payments.Links;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PayPalService payPalService;

    @GetMapping("/create")
public void createPayment(@RequestParam double total, HttpServletResponse response) throws IOException {
    try {
        Payment payment = payPalService.createPayment(
            total,
            "USD",
            "paypal",
            "sale",
            "Payment description",
            "http://localhost:8090/payments/cancel",
            "http://localhost:8090/payments/success"
        );

        String approvalLink = payment.getLinks().stream()
                .filter(link -> "approval_url".equals(link.getRel()))
                .findFirst()
                .map(Links::getHref)
                .orElseThrow(() -> new RuntimeException("Approval link not found"));

        // Redirect directly to PayPal login page
        response.sendRedirect(approvalLink);
    } catch (Exception e) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error creating payment: " + e.getMessage());
    }
}

    @GetMapping("/success")
    public ResponseEntity<String> paymentSuccess(@RequestParam("paymentId") String paymentId,
                                                 @RequestParam("PayerID") String payerId) {
        // ✅ Log to check if endpoint is hit
        System.out.println("💡 paymentSuccess() called with paymentId: " + paymentId + ", payerId: " + payerId);

        try {
            Payment payment = payPalService.executePayment(paymentId, payerId);
            System.out.println("✅ Payment executed: " + payment);
            return ResponseEntity.ok("Payment successful! Payment ID: " + payment.getId());
        } catch (Exception e) {
            System.err.println("❌ Payment failed: " + e.getMessage());
            return ResponseEntity.badRequest().body("Payment failed: " + e.getMessage());
        }
    }

    @GetMapping("/cancel")
    public ResponseEntity<String> paymentCancel() {
        System.out.println("💡 Payment cancelled");
        return ResponseEntity.ok("Payment was cancelled.");
    }
}
