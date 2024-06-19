package org.example.hospital_management.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hospital_management.entity.Patient;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomAssignRequest {
    private LocalDateTime admissionDate;
    private LocalDateTime dischargeDate;
    private Integer patient;
    private Integer room;
}
