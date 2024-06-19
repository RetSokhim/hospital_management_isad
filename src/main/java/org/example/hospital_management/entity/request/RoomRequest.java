package org.example.hospital_management.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    private Integer bedNumber;
    private Integer maxCapacity;
    private Integer currentOccupancy;
    private String status;
    private BigDecimal price;
}
