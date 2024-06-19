package org.example.hospital_management.service;

import org.example.hospital_management.entity.request.AppUserRegisterRequest;
import org.example.hospital_management.entity.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {
    UserResponse registerNewUser(AppUserRegisterRequest userRegisterRequest);
}
