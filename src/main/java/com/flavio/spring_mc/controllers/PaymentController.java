package com.flavio.spring_mc.controllers;

import com.flavio.spring_mc.services.PayPalService;
import com.paypal.api.payments.Payment;
import jakarta.servlet.http.HttpServletResponse;
import com.paypal.api.payments.Links;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PayPalService payPalService;

    @GetMapping("/create")
    public void createPayment(@RequestParam double total, HttpServletResponse response) throws IOException {
        try {
            // Updated cancel and success URLs with the correct domain (Render link)
            Payment payment = payPalService.createPayment(
                total,
                "USD",
                "paypal",
                "sale",
                "Payment description",
                "https://my-app-hckg.onrender.com/payments/cancel?token=10",  // Updated cancel URL
                "https://my-app-hckg.onrender.com/payments/success?token=10" // Updated success URL
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
    public ResponseEntity<String> paymentCancel(@RequestParam("token") String token) {
        // ✅ Log to check if the cancel request is hit and the token received
        System.out.println("💡 Payment cancelled with token: " + token);

        return ResponseEntity.ok("Payment was cancelled with token: " + token);
    }
}
