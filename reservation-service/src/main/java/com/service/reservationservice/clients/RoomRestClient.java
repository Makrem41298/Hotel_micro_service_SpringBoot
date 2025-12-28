package com.service.reservationservice.clients;

import com.service.reservationservice.Model.Client;
import com.service.reservationservice.Model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@FeignClient(name = "ROOM-SERVICE")
public interface RoomRestClient {
    @GetMapping("/api/rooms/{id}")
    Optional<Room> getRoomById(@PathVariable int id);
}
