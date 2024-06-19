package org.example.hospital_management.repository;

import org.apache.ibatis.annotations.*;
import org.example.hospital_management.entity.RoomAssign;

import java.util.List;

@Mapper
public interface RoomAssignRepository {
    @Insert("""
        INSERT INTO tbRoomAssign (admissionDate, dischargeDate, patientID, roomID)
        VALUES (#{admissionDate}, #{dischargeDate}, #{patient.patientId}, #{room.roomId})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "assignId")
    void addNewRoomAssign(RoomAssign roomAssign);

    @Select("SELECT * FROM tbRoomAssign WHERE assignId = #{assignId}")
    @Results(id = "roomAssignMapping", value = {
            @Result(property = "assignId", column = "assignId", id = true),
            @Result(property = "admissionDate", column = "admissionDate"),
            @Result(property = "dischargeDate", column = "dischargeDate"),
            @Result(property = "patient", column = "patientID",
                    one = @One(select = "org.example.hospital_management.repository.PatientRepository.getPatientById")),
            @Result(property = "room", column = "roomID",
                    one = @One(select = "org.example.hospital_management.repository.RoomRepository.getRoomById"))
    })
    RoomAssign getRoomAssignById(Integer assignId);

    @Select("SELECT * FROM tbRoomAssign")
    @ResultMap("roomAssignMapping")
    List<RoomAssign> getAllRoomAssigns();

    @Delete("DELETE FROM tbRoomAssign WHERE assignId = #{assignId}")
    void deleteRoomAssignById(Integer assignId);

    @Update("""
        UPDATE tbRoomAssign SET admissionDate = #{admissionDate}, dischargeDate = #{dischargeDate},
        patientID = #{patient.patientId}, roomID = #{room.roomId}
        WHERE assignId = #{assignId}
    """)
    void updateRoomAssignById(RoomAssign roomAssign);
}
