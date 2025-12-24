package com.service.roomservice.services;


import com.service.roomservice.entities.Room;

import java.util.List;
import java.util.Optional;

public interface IServiceRoom {


    public List<Room> getAllRooms();
    public Optional<Room> getRoomById(Integer id);
    public Optional<Room>  getRoomByNumberOfRoom(Integer numberOfRoom);
    public Room addNewRoom(Room room);
    public Room updateRoom(Room room, Integer id);
    public void deleteRoom(Integer id);
}
