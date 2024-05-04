package com.example.hotel.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>
{
    @Query("SELECT r FROM Room r WHERE r.guest IS NULL")
    List<Room> findEmptyRooms();

    @Query("SELECT r FROM Room r WHERE r.guest.id = :guestId")
    Room findRoomsByGuest(@Param("guestId") Long guestId);

}