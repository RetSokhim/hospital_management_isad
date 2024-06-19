package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomAssign {
    private Integer assignId;
    private LocalDateTime admissionDate;
    private LocalDateTime dischargeDate;
    private Patient patient;
    private Room room;
}
