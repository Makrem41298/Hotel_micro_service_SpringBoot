package com.service.reservationservice.mapper;

import com.service.reservationservice.Model.ReservationEvent;
import com.service.reservationservice.entities.Reservation;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MapperReservation {



    public static ReservationEvent toEventReservation(Reservation reservation) {
        ReservationEvent reservationEvent = new ReservationEvent();
        reservationEvent.setReservationId(reservation.getId());
        reservationEvent.setCheckInDate(reservation.getCheckInDate());
        reservationEvent.setCheckOutDate(reservation.getCheckOutDate());
        reservationEvent.setClientId(reservation.getClientId());
        reservationEvent.setRoomId(reservation.getRoomId());
        return reservationEvent;

    }

}
