package org.example.hospital_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.hospital_management.entity.Doctor;
import org.example.hospital_management.entity.request.DoctorRequest;
import org.example.hospital_management.entity.response.ApiResponse;
import org.example.hospital_management.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
@SecurityRequirement(name = "basicAuth")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping("/add-doctor")
    @Operation(summary = "Add new doctor")
    public ResponseEntity<?> addEmployee(@RequestBody DoctorRequest doctorRequest) {
        doctorService.addNewDoctor(doctorRequest);
        return new ResponseEntity<>(new ApiResponse<>("Doctor added successfully",
                HttpStatus.CREATED,
                null,
                201,
                LocalDateTime.now()),
                HttpStatus.CREATED);
    }

    @GetMapping("/get-doctor-by-id/{doctorId}")
    @Operation(summary = "Get doctor by ID")
    public ResponseEntity<?> getDoctorById(@PathVariable Integer doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        return new ResponseEntity<>(new ApiResponse<>("Get doctor by ID successfully",
                HttpStatus.OK,
                doctor,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-all-doctor")
    @Operation(summary = "Get all doctor")
    public ResponseEntity<?> getDoctorById() {
        List<Doctor> doctors = doctorService.getAllDoctor();
        return new ResponseEntity<>(new ApiResponse<>("Get all doctors successfully",
                HttpStatus.OK,
                doctors,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/delete-doctor-by-id/{doctorId}")
    @Operation(summary = "Delete doctor by ID")
    public ResponseEntity<?> deleteDoctorById(@PathVariable Integer doctorId) {
        doctorService.deleteDoctorById(doctorId);
        return new ResponseEntity<>(new ApiResponse<>("Delete doctor by ID successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/update-doctor-by-id/{doctorId}")
    @Operation(summary = "Update doctor by ID")
    public ResponseEntity<?> updateDoctorById(@RequestBody DoctorRequest doctorRequest,@PathVariable Integer doctorId) {
        Doctor doctor = doctorService.updateDoctorById(doctorId,doctorRequest);
        return new ResponseEntity<>(new ApiResponse<>("Update doctor by ID successfully",
                HttpStatus.OK,
                doctor,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }
}
