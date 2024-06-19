package org.example.hospital_management.service.serviceimpl;

import org.example.hospital_management.entity.Patient;
import org.example.hospital_management.entity.request.PatientRequest;
import org.example.hospital_management.repository.PatientRepository;
import org.example.hospital_management.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void addNewPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patientSetter(patientRequest, patient);
        patientRepository.addNewPatient(patient);
    }

    private void patientSetter(PatientRequest patientRequest, Patient patient) {
        patient.setNameEN(patientRequest.getNameEN());
        patient.setNameKH(patientRequest.getNameKH());
        patient.setSex(patientRequest.getSex());
        patient.setBirthDate(patientRequest.getBirthDate());
        patient.setContact(patientRequest.getContact());
        patient.setAddress(patientRequest.getAddress());
        patient.setMedicalHistory(patientRequest.getMedicalHistory());
    }

    @Override
    public Patient getPatientById(Integer patientId) {
        return patientRepository.getPatientById(patientId);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

    @Override
    public void deletePatientById(Integer patientId) {
        patientRepository.deletePatientById(patientId);
    }

    @Override
    public Patient updatePatientById(Integer patientId, PatientRequest patientRequest) {
        Patient patient = patientRepository.getPatientById(patientId);
        if (patient != null) {
            patientSetter(patientRequest, patient);
            patientRepository.updatePatientById(patient);
            return patient;
        }
        return null;
    }
}
