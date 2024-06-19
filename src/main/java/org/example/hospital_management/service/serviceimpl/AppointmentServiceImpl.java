package org.example.hospital_management.service.serviceimpl;

import org.example.hospital_management.entity.Appointment;
import org.example.hospital_management.entity.request.AppointmentRequest;
import org.example.hospital_management.repository.AppointmentRepository;
import org.example.hospital_management.repository.PatientRepository;
import org.example.hospital_management.repository.DoctorRepository;
import org.example.hospital_management.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void addNewAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setDescription(appointmentRequest.getDescription());
        appointment.setAppointmentType(appointmentRequest.getAppointmentType());
        appointment.setPatient(patientRepository.getPatientById(appointmentRequest.getPatient()));
        appointment.setDoctor(doctorRepository.getDoctorById(appointmentRequest.getDoctor()));
        appointmentRepository.addNewAppointment(appointment);
    }

    @Override
    public Appointment getAppointmentById(Integer appointmentId) {
        return appointmentRepository.getAppointmentById(appointmentId);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAllAppointments();
    }

    @Override
    public void deleteAppointmentById(Integer appointmentId) {
        appointmentRepository.deleteAppointmentById(appointmentId);
    }

    @Override
    public Appointment updateAppointmentById(Integer appointmentId, AppointmentRequest appointmentRequest) {
        Appointment appointment = appointmentRepository.getAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
            appointment.setDescription(appointmentRequest.getDescription());
            appointment.setAppointmentType(appointmentRequest.getAppointmentType());
            appointment.setPatient(patientRepository.getPatientById(appointmentRequest.getPatient()));
            appointment.setDoctor(doctorRepository.getDoctorById(appointmentRequest.getDoctor()));
            appointmentRepository.updateAppointmentById(appointment);
            return appointment;
        }
        return null;
    }
}
