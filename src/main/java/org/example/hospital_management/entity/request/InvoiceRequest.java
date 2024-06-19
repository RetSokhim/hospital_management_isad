package org.example.hospital_management.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate invoiceDate;
    private BigDecimal totalAmount;
    private BigDecimal paidAmount;
    private Integer patient;
    private Integer employee;
}
