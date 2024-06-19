package org.example.hospital_management.service;

import org.example.hospital_management.entity.Doctor;
import org.example.hospital_management.entity.request.DoctorRequest;

import java.util.List;

public interface DoctorService {
    void addNewDoctor(DoctorRequest doctorRequest);

    Doctor getDoctorById(Integer doctorId);

    List<Doctor> getAllDoctor();

    void deleteDoctorById(Integer doctorId);

    Doctor updateDoctorById(Integer doctorId, DoctorRequest doctorRequest);
}
