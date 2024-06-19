package org.example.hospital_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.hospital_management.entity.RoomAssign;
import org.example.hospital_management.entity.request.RoomAssignRequest;
import org.example.hospital_management.entity.response.ApiResponse;
import org.example.hospital_management.service.RoomAssignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/room-assign")
@SecurityRequirement(name = "basicAuth")
public class RoomAssignController {
    private final RoomAssignService roomAssignService;

    public RoomAssignController(RoomAssignService roomAssignService) {
        this.roomAssignService = roomAssignService;
    }

    @PostMapping("/add-room-assign")
    @Operation(summary = "Add new room assignment")
    public ResponseEntity<?> addRoomAssign(@RequestBody RoomAssignRequest roomAssignRequest) {
        roomAssignService.addNewRoomAssign(roomAssignRequest);
        return new ResponseEntity<>(new ApiResponse<>("Room assignment added successfully",
                HttpStatus.CREATED,
                null,
                201,
                LocalDateTime.now()),
                HttpStatus.CREATED);
    }

    @GetMapping("/get-room-assign-by-id/{assignId}")
    @Operation(summary = "Get room assignment by ID")
    public ResponseEntity<?> getRoomAssignById(@PathVariable Integer assignId) {
        RoomAssign roomAssign = roomAssignService.getRoomAssignById(assignId);
        return new ResponseEntity<>(new ApiResponse<>("Get room assignment by ID successfully",
                HttpStatus.OK,
                roomAssign,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-all-room-assigns")
    @Operation(summary = "Get all room assignments")
    public ResponseEntity<?> getAllRoomAssigns() {
        List<RoomAssign> roomAssigns = roomAssignService.getAllRoomAssigns();
        return new ResponseEntity<>(new ApiResponse<>("Get all room assignments successfully",
                HttpStatus.OK,
                roomAssigns,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete-room-assign-by-id/{assignId}")
    @Operation(summary = "Delete room assignment by ID")
    public ResponseEntity<?> deleteRoomAssignById(@PathVariable Integer assignId) {
        roomAssignService.deleteRoomAssignById(assignId);
        return new ResponseEntity<>(new ApiResponse<>("Delete room assignment by ID successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @PutMapping("/update-room-assign-by-id/{assignId}")
    @Operation(summary = "Update room assignment by ID")
    public ResponseEntity<?> updateRoomAssignById(@RequestBody RoomAssignRequest roomAssignRequest, @PathVariable Integer assignId) {
        RoomAssign updatedRoomAssign = roomAssignService.updateRoomAssignById(assignId, roomAssignRequest);
        return new ResponseEntity<>(new ApiResponse<>("Update room assignment by ID successfully",
                HttpStatus.OK,
                updatedRoomAssign,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }
}
