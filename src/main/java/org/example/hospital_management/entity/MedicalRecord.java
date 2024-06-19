package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
    private Integer mRID;
    private String examination;
    private String diagnosis;
    private String description;
    private Patient patient;
    private Doctor doctor;
    private Treatment treatment;
}
