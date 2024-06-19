package org.example.hospital_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.hospital_management.entity.Appointment;
import org.example.hospital_management.entity.request.AppointmentRequest;
import org.example.hospital_management.entity.response.ApiResponse;
import org.example.hospital_management.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
@SecurityRequirement(name = "basicAuth")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/add-appointment")
    @Operation(summary = "Add new appointment")
    public ResponseEntity<?> addAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        appointmentService.addNewAppointment(appointmentRequest);
        return new ResponseEntity<>(new ApiResponse<>("Appointment added successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-appointment-by-id/{appointmentId}")
    @Operation(summary = "Get appointment by ID")
    public ResponseEntity<?> getAppointmentById(@PathVariable Integer appointmentId) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        return new ResponseEntity<>(new ApiResponse<>("Get appointment by ID successfully",
                HttpStatus.OK,
                appointment,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-all-appointments")
    @Operation(summary = "Get all appointments")
    public ResponseEntity<?> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(new ApiResponse<>("Get all appointments successfully",
                HttpStatus.OK,
                appointments,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete-appointment-by-id/{appointmentId}")
    @Operation(summary = "Delete appointment by ID")
    public ResponseEntity<?> deleteAppointmentById(@PathVariable Integer appointmentId) {
        appointmentService.deleteAppointmentById(appointmentId);
        return new ResponseEntity<>(new ApiResponse<>("Appointment deleted successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @PutMapping("/update-appointment-by-id/{appointmentId}")
    @Operation(summary = "Update appointment by ID")
    public ResponseEntity<?> updateAppointmentById(@RequestBody AppointmentRequest appointmentRequest, @PathVariable Integer appointmentId) {
        Appointment appointment = appointmentService.updateAppointmentById(appointmentId, appointmentRequest);
        return new ResponseEntity<>(new ApiResponse<>("Updated appointment by ID successfully",
                HttpStatus.OK,
                appointment,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }
}
