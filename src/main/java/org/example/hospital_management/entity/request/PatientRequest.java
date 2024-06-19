package org.example.hospital_management.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
    private String nameEN;
    private String nameKH;
    private String sex;
    private LocalDate birthDate;
    private String contact;
    private String address;
    private String medicalHistory;
}
