package org.example.hospital_management.service;

import org.example.hospital_management.entity.RoomAssign;
import org.example.hospital_management.entity.request.RoomAssignRequest;

import java.util.List;

public interface RoomAssignService {
    void addNewRoomAssign(RoomAssignRequest roomAssignRequest);

    RoomAssign getRoomAssignById(Integer assignId);

    List<RoomAssign> getAllRoomAssigns();

    void deleteRoomAssignById(Integer assignId);

    RoomAssign updateRoomAssignById(Integer assignId, RoomAssignRequest roomAssignRequest);
}
