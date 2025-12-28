package com.service.reservationservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Integer id;
    private Integer number;
    private RoomType roomType;
    private BigDecimal price;
}
