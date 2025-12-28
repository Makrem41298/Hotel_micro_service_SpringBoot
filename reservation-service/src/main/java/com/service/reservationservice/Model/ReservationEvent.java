package com.service.reservationservice.Model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ReservationEvent {
    private Integer reservationId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer clientId;
    private Integer roomId;

}
