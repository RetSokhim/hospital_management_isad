package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentDetail {
    private String description;
    private Integer quantity;
    private String unit;
    private Treatment treatment;
    private Medicine medicine;
}
