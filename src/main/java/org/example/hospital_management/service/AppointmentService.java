package org.example.hospital_management.service;

import org.example.hospital_management.entity.Appointment;
import org.example.hospital_management.entity.request.AppointmentRequest;

import java.util.List;

public interface AppointmentService {
    void addNewAppointment(AppointmentRequest appointmentRequest);

    Appointment getAppointmentById(Integer appointmentId);

    List<Appointment> getAllAppointments();

    void deleteAppointmentById(Integer appointmentId);

    Appointment updateAppointmentById(Integer appointmentId, AppointmentRequest appointmentRequest);
}
