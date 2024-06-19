package org.example.hospital_management.service;

import org.example.hospital_management.entity.Payment;
import org.example.hospital_management.entity.request.PaymentRequest;

import java.util.List;

public interface PaymentService {
    void addNewPayment(PaymentRequest paymentRequest);

    Payment getPaymentById(Integer paymentId);

    List<Payment> getAllPayments();

    void deletePaymentById(Integer paymentId);

    Payment updatePaymentById(Integer paymentId, PaymentRequest paymentRequest);
}
