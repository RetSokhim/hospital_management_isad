package org.example.hospital_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.hospital_management.entity.Room;
import org.example.hospital_management.entity.request.RoomRequest;
import org.example.hospital_management.entity.response.ApiResponse;
import org.example.hospital_management.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/room")
@SecurityRequirement(name = "basicAuth")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add-room")
    @Operation(summary = "Add new room")
    public ResponseEntity<?> addRoom(@RequestBody RoomRequest roomRequest) {
        roomService.addNewRoom(roomRequest);
        return new ResponseEntity<>(new ApiResponse<>("Room added successfully",
                HttpStatus.CREATED,
                null,
                201,
                LocalDateTime.now()),
                HttpStatus.CREATED);
    }

    @GetMapping("/get-room-by-id/{roomId}")
    @Operation(summary = "Get room by ID")
    public ResponseEntity<?> getRoomById(@PathVariable Integer roomId) {
        Room room = roomService.getRoomById(roomId);
        return new ResponseEntity<>(new ApiResponse<>("Get room by ID successfully",
                HttpStatus.OK,
                room,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-all-rooms")
    @Operation(summary = "Get all rooms")
    public ResponseEntity<?> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(new ApiResponse<>("Get all rooms successfully",
                HttpStatus.OK,
                rooms,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete-room-by-id/{roomId}")
    @Operation(summary = "Delete room by ID")
    public ResponseEntity<?> deleteRoomById(@PathVariable Integer roomId) {
        roomService.deleteRoomById(roomId);
        return new ResponseEntity<>(new ApiResponse<>("Delete room by ID successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @PutMapping("/update-room-by-id/{roomId}")
    @Operation(summary = "Update room by ID")
    public ResponseEntity<?> updateRoomById(@RequestBody RoomRequest roomRequest, @PathVariable Integer roomId) {
        Room updatedRoom = roomService.updateRoomById(roomId, roomRequest);
        return new ResponseEntity<>(new ApiResponse<>("Update room by ID successfully",
                HttpStatus.OK,
                updatedRoom,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }
}
