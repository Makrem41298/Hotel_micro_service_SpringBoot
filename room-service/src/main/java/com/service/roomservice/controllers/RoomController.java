package com.service.roomservice.controllers;


import com.service.roomservice.entities.Room;
import com.service.roomservice.services.IServiceRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final IServiceRoom serviceRoom;

    public RoomController(IServiceRoom serviceRoom) {
        this.serviceRoom = serviceRoom;
    }
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(serviceRoom.getAllRooms());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Integer id) {

        return serviceRoom.getRoomById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room newRoom=serviceRoom.addNewRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRoom);
    }
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Integer id, @RequestBody Room room) {
        return serviceRoom.updateRoom(room,id) ;// 404
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Integer id) {
        serviceRoom.deleteRoom(id);
        return ResponseEntity.noContent().build(); // 204
    }


}
