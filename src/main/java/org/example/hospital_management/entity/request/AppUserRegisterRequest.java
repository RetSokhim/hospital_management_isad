package org.example.hospital_management.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.web.PortResolverImpl;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserRegisterRequest {
    private String username;
    private String email;
    private String password;
    private String userType;
}
