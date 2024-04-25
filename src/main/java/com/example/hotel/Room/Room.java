package com.example.hotel.Room;

import com.example.hotel.Guest.Guest;
import jakarta.persistence.*;
import org.attoparser.dom.Text;

import java.awt.*;

@Entity
@Table(name = "rooms")
public class Room
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String image;
    private double price;
    @Column(columnDefinition = "TEXT")
    private String description;

//    @OneToOne
//    @JoinColumns({
//            @JoinColumn(name = "guest_id"),
//            @JoinColumn(name = "guest_name")
//    })
    @ManyToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest_id;

    @ManyToOne
    @JoinColumn(name = "guest_name", referencedColumnName = "name")
    private Guest guest_name;

    public Room(Long id, String type, String image, double price, String description)
    {
        this.id = id;
        this.type = type;
        this.image = image;
        this.price = price;
        this.description = description;
    }

    public Room(String type, String image, double price, String description)
    {
        this.type = type;
        this.image = image;
        this.price = price;
        this.description = description;
    }

    public Room()
    {

    }


    public Long getId()
    {
        return id;
    }

    public String getType()
    {
        return type;
    }

    public String getImage()
    {
        return image;
    }

    public double getPrice()
    {
        return price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

//    public Guest getGuest()
//    {
//        return guest;
//    }
//
//    public void setGuest(Guest guest)
//    {
//        this.guest = guest;
//    }

    public Guest getGuest_id()
    {
        return guest_id;
    }

    public void setGuest_id(Guest guest_id)
    {
        this.guest_id = guest_id;
    }

    public Guest getGuest_name()
    {
        return guest_name;
    }

    public void setGuest_name(Guest guest_name)
    {
        this.guest_name = guest_name;
    }
}