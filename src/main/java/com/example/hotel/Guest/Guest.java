package com.example.hotel.Guest;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "guests")
public class Guest
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone_num;
    private String email;
    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private Long room_number;


    public Guest(Long id, String name, String phone_num, String email, LocalDate check_in_date, LocalDate check_out_date, Long roomNumber)
    {
        this.id = id;
        this.name = name;
        this.phone_num = phone_num;
        this.email = email;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        room_number = roomNumber;
    }

    public Guest(String name, String phone_num, String email, LocalDate check_in_date, LocalDate check_out_date, Long roomNumber)
    {
        this.name = name;
        this.phone_num = phone_num;
        this.email = email;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        room_number = roomNumber;
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

    public Long getRoom_number()
    {
        return room_number;
    }

    public void setRoom_number(Long room_number)
    {
        this.room_number = room_number;
    }
}
