package com.service.reservationservice.repository;

import com.service.reservationservice.Model.Client;
import com.service.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
