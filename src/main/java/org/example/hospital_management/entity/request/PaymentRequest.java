package org.example.hospital_management.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private LocalDate payDate;
    private BigDecimal paidAmount;
    private Integer patient;
    private Integer employee;
}
