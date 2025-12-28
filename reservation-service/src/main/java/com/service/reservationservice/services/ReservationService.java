package com.service.reservationservice.services;

import com.service.reservationservice.Model.Client;
import com.service.reservationservice.Model.Room;
import com.service.reservationservice.clients.ClientRestClient;
import com.service.reservationservice.clients.RoomRestClient;
import com.service.reservationservice.entities.Reservation;
import com.service.reservationservice.exception.ResourceNotFoundException;
import com.service.reservationservice.repository.ReservationRepository;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService implements IServiceReservation {
    private final ReservationRepository reservationRepository;
    private final  ClientRestClient clientRestClient;
    private final  RoomRestClient roomRestClient;

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> reservationsList= reservationRepository.findAll();
        for (Reservation reservation : reservationsList ) {
            try {
                Client client = clientRestClient
                        .getClientById(reservation.getClientId())
                        .orElse(null);
                reservation.setClient(client);
            } catch (FeignException.NotFound ex) {
                reservation.setClient(null);
            }

            try {
                roomRestClient.getRoomById(reservation.getRoomId())
                        .ifPresent(reservation::setRoom);
            }catch (FeignException.NotFound ex){
                reservation.setClient(null);
            }


        }
        return reservationsList;
    }

    @Override
    public Reservation getReservation(int id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Reservation not found with id: " + id));
        try {
            clientRestClient.getClientById(reservation.getClientId())
                    .ifPresent(reservation::setClient);
        }catch (FeignException.NotFound ex){
            reservation.setClient(null);
        }
        try {
            roomRestClient.getRoomById(reservation.getRoomId())
                    .ifPresent(reservation::setRoom);
        }catch (FeignException.NotFound ex){
            reservation.setClient(null);
        }



        return reservation;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {

        int clientId = reservation.getClientId();
        int roomId = reservation.getRoomId();
        try {
            clientRestClient.getClientById(clientId);
        } catch (FeignException.NotFound ex) {
            throw new ResourceNotFoundException("Client not found with id: " + clientId);
        }

        try {
            roomRestClient.getRoomById(roomId);
        } catch (FeignException.NotFound ex) {
            throw new ResourceNotFoundException("Room not found with id: " + roomId);
        }

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }
}
