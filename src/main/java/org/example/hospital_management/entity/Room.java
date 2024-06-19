package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Integer roomId;
    private Integer bedNumber;
    private Integer maxCapacity;
    private Integer currentOccupancy;
    private String status;
    private BigDecimal price;
}
