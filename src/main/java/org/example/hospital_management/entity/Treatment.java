package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treatment {
    private Integer treatmentId;
    private String treatmentType;
    private LocalDate treatmentDatetime;
    private String description;
    private Patient patient;
    private Doctor doctor;
}
