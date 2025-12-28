package com.service.roomservice.dto;

import com.service.roomservice.entities.Room;
import com.service.roomservice.entities.RoomType;
import lombok.*;

import java.math.BigDecimal;
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDto {
    public RoomResponseDto(Room room) {
        this.id = room.getId();
        this.number = room.getNumber();
        this.type = room.getType();
        this.rating = room.getRating();
        this.price = room.getPrice();
    }

    private Integer id;
    private Integer number;
    private RoomType type;
    private Integer rating;
    private BigDecimal price;
}
