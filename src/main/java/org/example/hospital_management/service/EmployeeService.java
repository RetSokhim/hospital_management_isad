package org.example.hospital_management.service;

import org.example.hospital_management.entity.Employee;
import org.example.hospital_management.entity.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    void addNewEmployee(EmployeeRequest employeeRequest);

    Employee getEmployeeById(Integer employeeId);

    List<Employee> getAllEmployee();

    void removeEmployee(Integer employeeId);

    Employee updateEmployeeByID(EmployeeRequest employeeRequest, Integer employeeId);
}
