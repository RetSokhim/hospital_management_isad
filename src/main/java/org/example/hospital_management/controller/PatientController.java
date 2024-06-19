package org.example.hospital_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.hospital_management.entity.Patient;
import org.example.hospital_management.entity.request.PatientRequest;
import org.example.hospital_management.entity.response.ApiResponse;
import org.example.hospital_management.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
@SecurityRequirement(name = "basicAuth")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/add-patient")
    @Operation(summary = "Add new patient")
    public ResponseEntity<?> addPatient(@RequestBody PatientRequest patientRequest) {
        patientService.addNewPatient(patientRequest);
        return new ResponseEntity<>(new ApiResponse<>("Patient added successfully",
                HttpStatus.CREATED,
                null,
                201,
                LocalDateTime.now()),
                HttpStatus.CREATED);
    }

    @GetMapping("/get-patient-by-id/{patientId}")
    @Operation(summary = "Get patient by ID")
    public ResponseEntity<?> getPatientById(@PathVariable Integer patientId) {
        Patient patient = patientService.getPatientById(patientId);
        return new ResponseEntity<>(new ApiResponse<>("Get patient by ID successfully",
                HttpStatus.OK,
                patient,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-all-patients")
    @Operation(summary = "Get all patients")
    public ResponseEntity<?> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(new ApiResponse<>("Get all patients successfully",
                HttpStatus.OK,
                patients,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete-patient-by-id/{patientId}")
    @Operation(summary = "Delete patient by ID")
    public ResponseEntity<?> deletePatientById(@PathVariable Integer patientId) {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(new ApiResponse<>("Delete patient by ID successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @PutMapping("/update-patient-by-id/{patientId}")
    @Operation(summary = "Update patient by ID")
    public ResponseEntity<?> updatePatientById(@RequestBody PatientRequest patientRequest, @PathVariable Integer patientId) {
        Patient updatedPatient = patientService.updatePatientById(patientId, patientRequest);
        return new ResponseEntity<>(new ApiResponse<>("Update patient by ID successfully",
                HttpStatus.OK,
                updatedPatient,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }
}
