package org.example.hospital_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.hospital_management.entity.Employee;
import org.example.hospital_management.entity.request.EmployeeRequest;
import org.example.hospital_management.entity.response.ApiResponse;
import org.example.hospital_management.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@SecurityRequirement(name = "basicAuth")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add-employee")
    @Operation(summary = "Register")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.addNewEmployee(employeeRequest);
        return new ResponseEntity<>(new ApiResponse<>("Employee added successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-all-employee")
    @Operation(summary = "Get all employee")
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(new ApiResponse<>("Get all employee successfully",
                HttpStatus.OK,
                employees,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-employee-id/{employeeId}")
    @Operation(summary = "Get employee by ID")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(new ApiResponse<>("Get employee by ID successfully",
                HttpStatus.OK,
                employee,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @DeleteMapping("/remove-employee/{employeeId}")
    @Operation(summary = "Remove employee")
    public ResponseEntity<?> removeEmployee(@PathVariable Integer employeeId) {
        employeeService.removeEmployee(employeeId);
        return new ResponseEntity<>(new ApiResponse<>("Employee removed successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @PutMapping("/update-employee-id/{employeeId}")
    @Operation(summary = "Update employee by ID")
    public ResponseEntity<?> updateEmployeeByID(@RequestBody EmployeeRequest employeeRequest, @PathVariable Integer employeeId) {
        Employee employee = employeeService.updateEmployeeByID(employeeRequest, employeeId);
        return new ResponseEntity<>(new ApiResponse<>("Updated employee by ID successfully",
                HttpStatus.OK,
                employee,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }
}
