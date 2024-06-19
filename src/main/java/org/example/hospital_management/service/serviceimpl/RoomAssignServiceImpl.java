package org.example.hospital_management.service.serviceimpl;

import org.example.hospital_management.entity.RoomAssign;
import org.example.hospital_management.entity.request.RoomAssignRequest;
import org.example.hospital_management.repository.PatientRepository;
import org.example.hospital_management.repository.RoomAssignRepository;
import org.example.hospital_management.repository.RoomRepository;
import org.example.hospital_management.service.RoomAssignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAssignServiceImpl implements RoomAssignService {
    private final RoomAssignRepository roomAssignRepository;
    private final PatientRepository patientRepository;
    private final RoomRepository roomRepository;

    public RoomAssignServiceImpl(RoomAssignRepository roomAssignRepository, PatientRepository patientRepository, RoomRepository roomRepository) {
        this.roomAssignRepository = roomAssignRepository;
        this.patientRepository = patientRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void addNewRoomAssign(RoomAssignRequest roomAssignRequest) {
        RoomAssign roomAssign = new RoomAssign();
        roomAssign.setAdmissionDate(roomAssignRequest.getAdmissionDate());
        roomAssign.setDischargeDate(roomAssignRequest.getDischargeDate());
        roomAssign.setPatient(patientRepository.getPatientById(roomAssignRequest.getPatient()));
        roomAssign.setRoom(roomRepository.getRoomById(roomAssignRequest.getRoom()));
        roomAssignRepository.addNewRoomAssign(roomAssign);
    }

    @Override
    public RoomAssign getRoomAssignById(Integer assignId) {
        return roomAssignRepository.getRoomAssignById(assignId);
    }

    @Override
    public List<RoomAssign> getAllRoomAssigns() {
        return roomAssignRepository.getAllRoomAssigns();
    }

    @Override
    public void deleteRoomAssignById(Integer assignId) {
        roomAssignRepository.deleteRoomAssignById(assignId);
    }

    @Override
    public RoomAssign updateRoomAssignById(Integer assignId, RoomAssignRequest roomAssignRequest) {
        RoomAssign roomAssign = roomAssignRepository.getRoomAssignById(assignId);
        if (roomAssign != null) {
            roomAssign.setAdmissionDate(roomAssignRequest.getAdmissionDate());
            roomAssign.setDischargeDate(roomAssignRequest.getDischargeDate());
            roomAssign.setPatient(patientRepository.getPatientById(roomAssignRequest.getPatient()));
            roomAssign.setRoom(roomRepository.getRoomById(roomAssignRequest.getRoom()));
            roomAssignRepository.updateRoomAssignById(roomAssign);
            return roomAssign;
        }
        return null;
    }
}
