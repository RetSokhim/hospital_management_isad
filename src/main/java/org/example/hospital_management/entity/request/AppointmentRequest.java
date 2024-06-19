package org.example.hospital_management.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hospital_management.entity.Patient;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    private Integer appointmentId;
    private LocalDate appointmentDate;
    private String description;
    private String appointmentType;
    private Integer patient;
    private Integer doctor;
}
