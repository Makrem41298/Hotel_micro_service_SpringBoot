package com.service.reservationservice.controllers;

import com.service.reservationservice.entities.Reservation;
import com.service.reservationservice.mapper.MapperReservation;
import com.service.reservationservice.services.IServiceReservation;
import com.service.reservationservice.services.ReservationProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IServiceReservation reservationService;
    private final ReservationProducer reservationEvent;


    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations() {
        return ResponseEntity.ok(reservationService.getReservations());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        return ResponseEntity.ok(reservationService.getReservation(id));
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        if (reservation.getCheckOutDate().isBefore(reservation.getCheckInDate())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        try {
            reservationEvent.placeReservation(
                    MapperReservation.toEventReservation(reservation)
            );
        } catch (Exception e) {
            System.err.println("Kafka not available, skipping event: " + e.getMessage());
        }

        Reservation saved = reservationService.addReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(
            @PathVariable Integer id,
            @RequestBody Reservation reservation) {

        reservation.setId(id);
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
