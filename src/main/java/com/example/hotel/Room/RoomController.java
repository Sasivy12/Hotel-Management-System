package com.example.hotel.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class RoomController
{
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public String showRooms(Model model)
    {
        List<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);

        return "rooms";
    }
}
