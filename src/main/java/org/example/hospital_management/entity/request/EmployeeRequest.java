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
public class EmployeeRequest {
    private String nameEN;
    private String nameKH;
    private String sex;
    private LocalDate birthDate;
    private String staffPosition;
    private String contact;
    private String address;
    private BigDecimal salary;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate hireDate;
}
