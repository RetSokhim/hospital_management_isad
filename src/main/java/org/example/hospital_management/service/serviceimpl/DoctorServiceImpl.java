package org.example.hospital_management.service.serviceimpl;

import org.example.hospital_management.entity.Doctor;
import org.example.hospital_management.entity.request.DoctorRequest;
import org.example.hospital_management.repository.DoctorRepository;
import org.example.hospital_management.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void addNewDoctor(DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor();
        doctor(doctorRequest, doctor);
        doctorRepository.addNewDoctor(doctor);
    }

    private void doctor(DoctorRequest doctorRequest, Doctor doctor) {
        doctor.setNameEN(doctorRequest.getNameEN());
        doctor.setNameKH(doctorRequest.getNameKH());
        doctor.setSex(doctorRequest.getSex());
        doctor.setEmail(doctorRequest.getEmail());
        doctor.setAddress(doctorRequest.getAddress());
        doctor.setContact(doctorRequest.getContact());
        doctor.setBirthDate(doctorRequest.getBirthDate());
        doctor.setSpecialist(doctorRequest.getSpecialist());
    }

    @Override
    public Doctor getDoctorById(Integer doctorId) {
        return doctorRepository.getDoctorById(doctorId);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.getAllDoctor();
    }

    @Override
    public void deleteDoctorById(Integer doctorId) {
        doctorRepository.deleteDoctorById(doctorId);
    }

    @Override
    public Doctor updateDoctorById(Integer doctorId, DoctorRequest doctorRequest) {
        Doctor doctor = doctorRepository.getDoctorById(doctorId);
        if (doctor != null) {
            doctor(doctorRequest, doctor);
            doctorRepository.updateDoctorById(doctorRequest,doctorId);
            return doctor;
        }
        return null;
    }
}
