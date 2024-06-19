package org.example.hospital_management.service.serviceimpl;

import org.example.hospital_management.entity.Employee;
import org.example.hospital_management.entity.request.EmployeeRequest;
import org.example.hospital_management.repository.EmployeeRepository;
import org.example.hospital_management.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addNewEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employeeSetter(employeeRequest, employee);
        employeeRepository.addNewEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public void removeEmployee(Integer employeeId) {
        employeeRepository.removeEmployee(employeeId);
    }

    @Override
    public Employee updateEmployeeByID(EmployeeRequest employeeRequest, Integer employeeId) {
        Employee employee = employeeRepository.getEmployeeById(employeeId);
        if (employee != null) {
            employeeSetter(employeeRequest, employee);
            employeeRepository.updateEmployeeByID(employee,employeeId);
            return employee;
        }
        return null;
    }

    private void employeeSetter(EmployeeRequest employeeRequest, Employee employee) {
        employee.setNameEN(employeeRequest.getNameEN());
        employee.setNameKH(employeeRequest.getNameKH());
        employee.setSex(employeeRequest.getSex());
        employee.setBirthDate(employeeRequest.getBirthDate());
        employee.setStaffPosition(employeeRequest.getStaffPosition());
        employee.setContact(employeeRequest.getContact());
        employee.setAddress(employeeRequest.getAddress());
        employee.setSalary(employeeRequest.getSalary());
        employee.setHireDate(employeeRequest.getHireDate());
    }
}
