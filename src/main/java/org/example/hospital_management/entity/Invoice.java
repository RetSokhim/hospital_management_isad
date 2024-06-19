package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private Integer invoiceId;
    private LocalDate invoiceDate;
    private BigDecimal totalAmount;
    private BigDecimal paidAmount;
    private Patient patient;
    private Employee employee;
}
