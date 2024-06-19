package org.example.hospital_management.service;

import org.example.hospital_management.entity.Room;
import org.example.hospital_management.entity.request.RoomRequest;

import java.util.List;

public interface RoomService {
    void addNewRoom(RoomRequest roomRequest);

    Room getRoomById(Integer roomId);

    List<Room> getAllRooms();

    void deleteRoomById(Integer roomId);

    Room updateRoomById(Integer roomId, RoomRequest roomRequest);
}
