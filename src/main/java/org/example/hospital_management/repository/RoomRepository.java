package org.example.hospital_management.repository;

import org.apache.ibatis.annotations.*;
import org.example.hospital_management.entity.Room;

import java.util.List;

@Mapper
public interface RoomRepository {
    @Insert("""
        INSERT INTO tbRoom (bedNumber, maxCapacity, currentOccupancy, status, price)
        VALUES (#{bedNumber}, #{maxCapacity}, #{currentOccupancy}, #{status}, #{price})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "roomId")
    void addNewRoom(Room room);

    @Select("SELECT * FROM tbRoom WHERE roomId = #{roomId}")
    Room getRoomById(Integer roomId);

    @Select("SELECT * FROM tbRoom")
    List<Room> getAllRooms();

    @Delete("DELETE FROM tbRoom WHERE roomId = #{roomId}")
    void deleteRoomById(Integer roomId);

    @Update("""
        UPDATE tbRoom SET bedNumber = #{bedNumber}, maxCapacity = #{maxCapacity}, currentOccupancy = #{currentOccupancy},
        status = #{status}, price = #{price}
        WHERE roomId = #{roomId}
    """)
    void updateRoomById(Room room);
}
