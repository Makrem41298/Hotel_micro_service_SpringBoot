package com.service.roomservice.services;

import com.service.roomservice.entities.StatusRoom;
import com.service.roomservice.model.ReservationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ReservationConsumer {
    private final IServiceRoom serviceRoom;
    @Bean
    public Consumer<ReservationEvent> reservationIn() {

        return event -> {
            System.out.println("📥 Reservation received in Room Service: " + event);
            System.out.println("🏨 Room reserved, roomId = " + event.getRoomId());
            serviceRoom.updateStatusRoom(event.getRoomId(),StatusRoom.BOOKED);


        };
    }
}
