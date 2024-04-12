package com.example.hotel.Room;

import jakarta.persistence.*;
import org.attoparser.dom.Text;

import java.awt.*;

@Entity
@Table(name = "rooms")
public class Room
{
    /*
    id
    type
    image
    price
    description
    occupied
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String image;
    private double price;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Long occupied;

    public Room(Long id, String type, String image, double price, String description, Long occupied, String occupiedByWho)
    {
        this.id = id;
        this.type = type;
        this.image = image;
        this.price = price;
        this.description = description;
        this.occupied = occupied;
    }

    public Room(String type, String image, double price, String description, Long occupied, String occupiedByWho)
    {
        this.type = type;
        this.image = image;
        this.price = price;
        this.description = description;
        this.occupied = occupied;
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

    public Long getOccupied()
    {
        return occupied;
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

    public void setOccupied(Long occupied)
    {
        this.occupied = occupied;
    }
}
