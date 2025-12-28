package com.service.reservationservice.services;

import com.service.reservationservice.Model.ReservationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationProducer {
    private final StreamBridge streamBridge;

    public void placeReservation(ReservationEvent reservationEvent) {
        streamBridge.send("reservation-out", reservationEvent);
        System.out.println("Sent reservation to Kafka: " + reservationEvent);
    }
}
