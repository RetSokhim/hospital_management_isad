package org.example.hospital_management.service.serviceimpl;

import org.example.hospital_management.entity.Room;
import org.example.hospital_management.entity.request.RoomRequest;
import org.example.hospital_management.repository.RoomRepository;
import org.example.hospital_management.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void addNewRoom(RoomRequest roomRequest) {
        Room room = new Room();
        room.setBedNumber(roomRequest.getBedNumber());
        room.setMaxCapacity(roomRequest.getMaxCapacity());
        room.setCurrentOccupancy(roomRequest.getCurrentOccupancy());
        room.setStatus(roomRequest.getStatus());
        room.setPrice(roomRequest.getPrice());
        roomRepository.addNewRoom(room);
    }

    @Override
    public Room getRoomById(Integer roomId) {
        return roomRepository.getRoomById(roomId);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public void deleteRoomById(Integer roomId) {
        roomRepository.deleteRoomById(roomId);
    }

    @Override
    public Room updateRoomById(Integer roomId, RoomRequest roomRequest) {
        Room room = roomRepository.getRoomById(roomId);
        if (room != null) {
            room.setBedNumber(roomRequest.getBedNumber());
            room.setMaxCapacity(roomRequest.getMaxCapacity());
            room.setCurrentOccupancy(roomRequest.getCurrentOccupancy());
            room.setStatus(roomRequest.getStatus());
            room.setPrice(roomRequest.getPrice());
            roomRepository.updateRoomById(room);
            return room;
        }
        return null;
    }
}
