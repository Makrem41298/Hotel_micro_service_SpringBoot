package com.service.reservationservice.services;

import com.service.reservationservice.entities.Reservation;

import java.util.List;

public interface IServiceReservation {
    public List<Reservation> getReservations();
    public Reservation getReservation(int id);
    public Reservation addReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservation(int id);


}
