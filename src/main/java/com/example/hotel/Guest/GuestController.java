package com.example.hotel.Guest;

import com.example.hotel.Guest.Guest;
import com.example.hotel.Guest.GuestRepository;
import com.example.hotel.Room.Room;
import com.example.hotel.Room.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController
{
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/")
    public String getGuests(Model model)
    {
        List<Guest> guests = guestRepository.findAll();
        model.addAttribute("guests", guests);

        return "guests";
    }

    @GetMapping("/delete")
    public String deleteGuest(@RequestParam Long guestId)
    {
        guestRepository.deleteById(guestId);

        return "redirect:/guests/";
    }

    @GetMapping("/add")
    public String addGuest(Model model)
    {
        Guest guest = new Guest();
        model.addAttribute("guest", guest);

        List<Room> emptyRooms = roomRepository.findEmptyRooms();
        model.addAttribute("emptyRooms",emptyRooms);

        return "addguest";
    }

    @PostMapping("/save")
    public String saveGuest(@ModelAttribute("guest") Guest guest)
    {
        guestRepository.save(guest);

        return "redirect:/guests/";
    }

    @GetMapping("/edit/{id}")
    public String editGuest(@PathVariable Long id, Model model)
    {
        model.addAttribute("guest", guestRepository.findById(id).get());

        return "edit_guest";
    }

    @PostMapping("/update/{id}")
    public String updateGuest(@PathVariable Long id, @ModelAttribute("guest") Guest guest)
    {

        Guest existingGuest = guestRepository.findById(id).get();
        existingGuest.setName(guest.getName());
        existingGuest.setPhone_num(guest.getPhone_num());
        existingGuest.setEmail(guest.getEmail());
        existingGuest.setCheck_in_date(guest.getCheck_in_date());
        existingGuest.setCheck_out_date(guest.getCheck_out_date());

        guestRepository.save(guest);

        return "redirect:/guests/";
    }
}