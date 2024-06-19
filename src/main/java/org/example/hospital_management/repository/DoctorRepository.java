package org.example.hospital_management.repository;

import org.apache.ibatis.annotations.*;
import org.example.hospital_management.entity.Doctor;
import org.example.hospital_management.entity.request.DoctorRequest;

import java.util.List;

@Mapper
public interface DoctorRepository {
    @Insert("INSERT INTO tbDoctor (nameEN, nameKH, sex, email, address, contact, birthDate, specialist) " +
            "VALUES (#{nameEN}, #{nameKH}, #{sex}, #{email}, #{address}, #{contact}, #{birthDate}, #{specialist})")
    void addNewDoctor(Doctor doctor);

    @Select("SELECT * FROM tbDoctor WHERE DoctorID = #{doctorId}")
    Doctor getDoctorById(Integer id);

    @Select("SELECT * FROM tbDoctor")
    List<Doctor> getAllDoctor();

    @Delete("DELETE FROM tbDoctor WHERE DoctorID = #{doctorId}")
    void deleteDoctorById(Integer id);

    @Update("""
    UPDATE tbDoctor SET nameEN = #{nameEN}, nameKH = #{nameKH}, sex = #{sex}, email = #{email},
    address = #{address}, contact = #{contact}, birthDate = #{birthDate}, specialist = #{specialist}
    WHERE DoctorID = #{doctorId}
    """)
    void updateDoctorById(DoctorRequest doctor, Integer doctorId);
}
