package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer employeeId;
    private String nameEN;
    private String nameKH;
    private String sex;
    private LocalDate birthDate;
    private String staffPosition;
    private String contact;
    private String address;
    private BigDecimal salary;
    private LocalDate hireDate;
    private String photo;
    private Byte stoppedWork;
    private AppUser user;
}
