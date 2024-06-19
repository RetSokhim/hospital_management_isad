package org.example.hospital_management.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequest {
    private String nameEN;
    private String nameKH;
    private String sex;
    private String email;
    private String address;
    private String contact;
    private LocalDate birthDate;
    private String specialist;
}
