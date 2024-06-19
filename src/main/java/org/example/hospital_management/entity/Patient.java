package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Integer patientId;
    private String nameEN;
    private String nameKH;
    private String sex;
    private LocalDate birthDate;
    private String contact;
    private String address;
    private String medicalHistory;
}
