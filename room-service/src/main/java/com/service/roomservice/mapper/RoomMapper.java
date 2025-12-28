package com.service.roomservice.mapper;

import com.service.roomservice.dto.RoomRequestDto;
import com.service.roomservice.entities.Room;

public class RoomMapper {
    public static Room toEntity(RoomRequestDto dto) {
        Room room = new Room();
        room.setNumber(dto.getNumber());
        room.setType(dto.getType());
        room.setStatus(dto.getStatus());
        room.setRating(dto.getRating());
        room.setPrice(dto.getPrice());
        return room;
    }
}
