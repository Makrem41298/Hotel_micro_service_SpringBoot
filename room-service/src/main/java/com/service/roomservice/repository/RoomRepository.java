package com.service.roomservice.repository;

import com.service.roomservice.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    public Optional<Room> findByNumber(Integer number);
}
