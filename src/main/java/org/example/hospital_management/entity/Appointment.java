package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    private Integer appointmentId;
    private LocalDate appointmentDate;
    private String description;
    private String appointmentType;
    private Patient patient;
    private Doctor doctor;
}
