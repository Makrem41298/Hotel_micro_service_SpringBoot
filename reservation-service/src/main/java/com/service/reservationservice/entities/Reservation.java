package com.service.reservationservice.entities;

import com.service.reservationservice.Model.Client;
import com.service.reservationservice.Model.Room;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter

public class Reservation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate checkInDate;
    @Column(nullable = false)
    private LocalDate checkOutDate;
    @Column(nullable = false)
    private Integer clientId;
    @Transient
    private Client client;
    @Column(nullable = false)
    private Integer roomId;
    @Transient
    private Room room;

}
