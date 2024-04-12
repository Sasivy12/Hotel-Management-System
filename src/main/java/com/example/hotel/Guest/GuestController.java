package com.example.hotel.Guest;

import com.example.hotel.Guest.Guest;
import com.example.hotel.Guest.GuestRepository;
import com.example.hotel.Room.Room;
import com.example.hotel.Room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/")
public class GuestController
{
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping({"/guests", "/"})
    public String getGuests(Model model)
    {
        List<Guest> guests = guestRepository.findAll();
        model.addAttribute("guests", guests);

        return "guests";
    }

    @GetMapping("/guests/delete")
    public String deleteGuest(@RequestParam Long guestId)
    {
        guestRepository.deleteById(guestId);

        return "redirect:/guests";
    }

    @GetMapping("/guests/add")
    public String addGuest(Model model)
    {
        Guest guest = new Guest();
        model.addAttribute("guest", guest);

        return "addguest";
    }

    @PostMapping("/guests/save")
    public String saveGuest(@ModelAttribute("guest") Guest guest)
    {
        guestRepository.save(guest);

        return "redirect:/guests";
    }

    @GetMapping("/guests/edit/{id}")
    public String editGuest(@PathVariable Long id, Model model)
    {
        model.addAttribute("guest", guestRepository.findById(id).get());

        return "edit_guest";
    }

    @PostMapping("/guests/{id}")
    public String updateGuest(@PathVariable Long id, @ModelAttribute("guest") Guest guest)
    {
        Guest existingGuest = guestRepository.findById(id).get();
        existingGuest.setName(guest.getName());
        existingGuest.setPhone_num(guest.getPhone_num());
        existingGuest.setEmail(guest.getEmail());
        existingGuest.setCheck_in_date(guest.getCheck_in_date());
        existingGuest.setCheck_out_date(guest.getCheck_out_date());

        guestRepository.save(guest);

        return "redirect:/guests";
    }

//    @GetMapping("/rooms")
//    public String showRooms(Model model)
//    {
//        List<Room> rooms = roomRepository.findAll();
//        model.addAttribute("rooms", rooms);
//
//        return "rooms";
//    }
}
