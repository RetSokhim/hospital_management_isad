package org.example.hospital_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.hospital_management.entity.Payment;
import org.example.hospital_management.entity.request.PaymentRequest;
import org.example.hospital_management.entity.response.ApiResponse;
import org.example.hospital_management.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/payment")
@SecurityRequirement(name = "basicAuth")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/add-payment")
    @Operation(summary = "Add new payment")
    public ResponseEntity<?> addPayment(@RequestBody PaymentRequest paymentRequest) {
        paymentService.addNewPayment(paymentRequest);
        return new ResponseEntity<>(new ApiResponse<>("Payment added successfully",
                HttpStatus.CREATED,
                null,
                201,
                LocalDateTime.now()),
                HttpStatus.CREATED);
    }

    @GetMapping("/get-payment-by-id/{paymentId}")
    @Operation(summary = "Get payment by ID")
    public ResponseEntity<?> getPaymentById(@PathVariable Integer paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);
        return new ResponseEntity<>(new ApiResponse<>("Get payment by ID successfully",
                HttpStatus.OK,
                payment,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-all-payments")
    @Operation(summary = "Get all payments")
    public ResponseEntity<?> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(new ApiResponse<>("Get all payments successfully",
                HttpStatus.OK,
                payments,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete-payment-by-id/{paymentId}")
    @Operation(summary = "Delete payment by ID")
    public ResponseEntity<?> deletePaymentById(@PathVariable Integer paymentId) {
        paymentService.deletePaymentById(paymentId);
        return new ResponseEntity<>(new ApiResponse<>("Delete payment by ID successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @PutMapping("/update-payment-by-id/{paymentId}")
    @Operation(summary = "Update payment by ID")
    public ResponseEntity<?> updatePaymentById(@RequestBody PaymentRequest paymentRequest, @PathVariable Integer paymentId) {
        Payment updatedPayment = paymentService.updatePaymentById(paymentId, paymentRequest);
        return new ResponseEntity<>(new ApiResponse<>("Update payment by ID successfully",
                HttpStatus.OK,
                updatedPayment,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }
}
