package org.example.hospital_management.repository;

import org.apache.ibatis.annotations.*;
import org.example.hospital_management.entity.Patient;

import java.util.List;

@Mapper
public interface PatientRepository {
    @Insert("""
        INSERT INTO tbPatient (nameEN, nameKH, sex, birthDate, contact, address, medicalHistory)
        VALUES (#{nameEN}, #{nameKH}, #{sex}, #{birthDate}, #{contact}, #{address}, #{medicalHistory})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "patientId")
    void addNewPatient(Patient patient);

    @Select("SELECT * FROM tbPatient WHERE patientId = #{patientId}")
    Patient getPatientById(Integer patientId);

    @Select("SELECT * FROM tbPatient")
    List<Patient> getAllPatients();

    @Delete("DELETE FROM tbPatient WHERE patientId = #{patientId}")
    void deletePatientById(Integer patientId);

    @Update("""
        UPDATE tbPatient SET nameEN = #{nameEN}, nameKH = #{nameKH}, sex = #{sex}, birthDate = #{birthDate},
        contact = #{contact}, address = #{address}, medicalHistory = #{medicalHistory}
        WHERE patientId = #{patientId}
    """)
    void updatePatientById(Patient patient);
}
