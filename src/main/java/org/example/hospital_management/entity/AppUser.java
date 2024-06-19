package org.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    private Integer userId;
    private String username;
    private String email;
    private String password;
    private String userType;
    private Byte status;
}
