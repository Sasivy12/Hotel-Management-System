package com.example.hotel;

import com.example.hotel.Guest.Guest;
import com.example.hotel.Guest.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller
{
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello World";
    }

    @GetMapping("/guests")
    public String getGuests(Model model)
    {
        List<Guest> guests = guestRepository.findAll();
        model.addAttribute("guests", guests);

        return "guests";
    }
}
