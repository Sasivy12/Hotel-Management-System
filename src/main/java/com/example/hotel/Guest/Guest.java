package com.example.hotel.Guest;

import com.example.hotel.Room.Room;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;

@Entity
@Table(name = "guests")
public class Guest
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone_num;
    private String email;
    private LocalDate check_in_date;
    private LocalDate check_out_date;

    @OneToOne
    @JoinColumn(name = "room_id")
    Room room;

    public Guest(Long id, String name, String phone_num, String email, LocalDate check_in_date, LocalDate check_out_date)
    {
        this.id = id;
        this.name = name;
        this.phone_num = phone_num;
        this.email = email;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
    }

    public Guest(String name, String phone_num, String email, LocalDate check_in_date, LocalDate check_out_date)
    {
        this.name = name;
        this.phone_num = phone_num;
        this.email = email;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
    }

    public Guest()
    {

    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPhone_num()
    {
        return phone_num;
    }

    public String getEmail()
    {
        return email;
    }

    public LocalDate getCheck_in_date()
    {
        return check_in_date;
    }

    public LocalDate getCheck_out_date()
    {
        return check_out_date;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhone_num(String phone_num)
    {
        this.phone_num = phone_num;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setCheck_in_date(LocalDate check_in_date)
    {
        this.check_in_date = check_in_date;
    }

    public void setCheck_out_date(LocalDate check_out_date)
    {
        this.check_out_date = check_out_date;
    }

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room = room;
    }
}