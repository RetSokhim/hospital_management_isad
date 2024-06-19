package org.example.hospital_management.repository;

import org.apache.ibatis.annotations.*;
import org.example.hospital_management.entity.Appointment;

import java.util.List;

@Mapper
public interface AppointmentRepository {
    @Insert("""
        INSERT INTO tbAppointment (appointmentDate, description, appointmentType, patientID, doctorID)
        VALUES (#{appointmentDate}, #{description}, #{appointmentType}, #{patient.patientId}, #{doctor.doctorId})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "appointmentId")
    void addNewAppointment(Appointment appointment);

    @Select("SELECT * FROM tbAppointment WHERE appointmentId = #{appointmentId}")
    @Results(id = "appointmentMapping", value = {
            @Result(property = "appointmentId", column = "appointmentId", id = true),
            @Result(property = "appointmentDate", column = "appointmentDate"),
            @Result(property = "description", column = "description"),
            @Result(property = "appointmentType", column = "appointmentType"),
            @Result(property = "patient", column = "patientID",
                    one = @One(select = "org.example.hospital_management.repository.PatientRepository.getPatientById")),
            @Result(property = "doctor", column = "doctorID",
                    one = @One(select = "org.example.hospital_management.repository.DoctorRepository.getDoctorById"))
    })
    Appointment getAppointmentById(Integer appointmentId);

    @Select("SELECT * FROM tbAppointment")
    @ResultMap("appointmentMapping")
    List<Appointment> getAllAppointments();

    @Delete("DELETE FROM tbAppointment WHERE appointmentId = #{appointmentId}")
    void deleteAppointmentById(Integer appointmentId);

    @Update("""
        UPDATE tbAppointment SET appointmentDate = #{appointmentDate}, description = #{description},
        appointmentType = #{appointmentType}, patientID = #{patient.patientId}, doctorID = #{doctor.doctorId}
        WHERE appointmentId = #{appointmentId}
    """)
    void updateAppointmentById(Appointment appointment);
}
