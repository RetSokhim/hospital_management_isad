package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private Integer doctorId;
    private String nameEN;
    private String nameKH;
    private String sex;
    private String email;
    private String address;
    private String contact;
    private LocalDate birthDate;
    private String specialist;
}
