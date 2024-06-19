package org.example.hospital_management.service;

import org.example.hospital_management.entity.Patient;
import org.example.hospital_management.entity.request.PatientRequest;

import java.util.List;

public interface PatientService {
    void addNewPatient(PatientRequest patientRequest);

    Patient getPatientById(Integer patientId);

    List<Patient> getAllPatients();

    void deletePatientById(Integer patientId);

    Patient updatePatientById(Integer patientId, PatientRequest patientRequest);
}
