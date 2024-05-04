package com.example.hotel.Room;

import com.example.hotel.Guest.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>
{
//    @Query("SELECT r FROM Room r WHERE NOT EXISTS (SELECT g FROM Guest g WHERE g.room = r)")
    @Query("SELECT r FROM Room r WHERE r.guest IS NULL")
    List<Room> findEmptyRooms();
}