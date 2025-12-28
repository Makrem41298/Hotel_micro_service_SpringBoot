package com.service.roomservice.services;


import com.service.roomservice.entities.Room;
import com.service.roomservice.entities.StatusRoom;
import com.service.roomservice.exception.ResourceNotFoundException;
import com.service.roomservice.repository.RoomRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter @Getter

public class RoomService implements IServiceRoom {
    private  RoomRepository roomRepository;
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomById(Integer id) {
        return roomRepository.findById(id);
    }

    @Override
    public Optional<Room> getRoomByNumberOfRoom(Integer numberOfRoom) {
        return roomRepository.findByNumber(numberOfRoom);
    }

    @Override
    public Room addNewRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room room, Integer id) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Room not found with id: " + id));
        System.out.println(existingRoom);
        room.setId(id);
        return roomRepository.save(room) ;
    }




    @Override
    public void deleteRoom(Integer id) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Room not found with id: " + id));
        roomRepository.delete(existingRoom);
    }

    @Override
    public void updateStatusRoom(int roomId, StatusRoom statusRoom) {
        Room existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Room not found with id: " + roomId));
        existingRoom.setStatus(statusRoom);
      roomRepository.save(existingRoom);
    }


}
