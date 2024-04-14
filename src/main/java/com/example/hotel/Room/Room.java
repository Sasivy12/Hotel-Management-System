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
    occupied_id
    occupied_name
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String image;
    private double price;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Long occupied_id;
    private String occupied_name;

    public Room(Long id, String type, String image, double price, String description, Long occupied_id, String occupiedName)
    {
        this.id = id;
        this.type = type;
        this.image = image;
        this.price = price;
        this.description = description;
        this.occupied_id = occupied_id;
        this.occupied_name = occupiedName;
    }

    public Room(String type, String image, double price, String description, Long occupied_id, String occupiedName)
    {
        this.type = type;
        this.image = image;
        this.price = price;
        this.description = description;
        this.occupied_id = occupied_id;
        this.occupied_name = occupiedName;
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

    public Long getOccupied_id()
    {
        return occupied_id;
    }

    public void setOccupied_id(Long occupied_id)
    {
        this.occupied_id = occupied_id;
    }

    public String getOccupied_name()
    {
        return occupied_name;
    }

    public void setOccupied_name(String occupied_name)
    {
        this.occupied_name = occupied_name;
    }
}