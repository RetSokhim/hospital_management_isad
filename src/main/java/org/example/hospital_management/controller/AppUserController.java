package org.example.hospital_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.hospital_management.entity.request.AppUserRegisterRequest;
import org.example.hospital_management.entity.response.ApiResponse;
import org.example.hospital_management.entity.response.UserResponse;
import org.example.hospital_management.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/user")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/register")
    @Operation(summary = "Register")
    public ResponseEntity<?> register(@RequestBody AppUserRegisterRequest userRegisterRequest) {
        UserResponse user = appUserService.registerNewUser(userRegisterRequest);
        return new ResponseEntity<>(new ApiResponse<>("Register successfully",
                HttpStatus.CREATED,
                user,
                201,
                LocalDateTime.now()),
                HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//    @Operation(summary = "Login with email and password")
//    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(userLoginRequest.getEmail(), userLoginRequest.getPassword())
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<>(new ApiResponse<>("Login successful",
//                HttpStatus.OK,
//                null,
//                200,
//                LocalDateTime.now()),
//                HttpStatus.OK);
//    }
}
