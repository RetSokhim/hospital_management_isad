package org.example.hospital_management.service.serviceimpl;

import org.example.hospital_management.entity.Payment;
import org.example.hospital_management.entity.request.PaymentRequest;
import org.example.hospital_management.repository.EmployeeRepository;
import org.example.hospital_management.repository.PatientRepository;
import org.example.hospital_management.repository.PaymentRepository;
import org.example.hospital_management.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        this.paymentRepository = paymentRepository;
        this.employeeRepository = employeeRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void addNewPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setPayDate(paymentRequest.getPayDate());
        payment.setPaidAmount(paymentRequest.getPaidAmount());
        payment.setPatient(patientRepository.getPatientById(paymentRequest.getPatient()));
        payment.setEmployee(employeeRepository.getEmployeeById(paymentRequest.getEmployee()));
        paymentRepository.addNewPayment(paymentRequest);
    }

    @Override
    public Payment getPaymentById(Integer paymentId) {
        return paymentRepository.getPaymentById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    @Override
    public void deletePaymentById(Integer paymentId) {
        paymentRepository.deletePaymentById(paymentId);
    }

    @Override
    public Payment updatePaymentById(Integer paymentId, PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.getPaymentById(paymentId);
        if (payment != null) {
            payment.setPayDate(paymentRequest.getPayDate());
            payment.setPaidAmount(paymentRequest.getPaidAmount());
            payment.setPatient(patientRepository.getPatientById(paymentRequest.getPatient()));
            payment.setEmployee(employeeRepository.getEmployeeById(paymentRequest.getEmployee()));
            paymentRepository.updatePaymentById(paymentRequest, paymentId);
            return payment;
        }
        return null;
    }
}
