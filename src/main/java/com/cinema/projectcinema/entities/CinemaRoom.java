package com.cinema.projectcinema.entities;

import javax.persistence.*;

@Entity
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String CinemaRooms;

    @Column(length = 45)
    private String maxGuests;

    public CinemaRoom() {
    }

    public CinemaRoom(int id, String cinemaRooms, String maxGuests) {
        this.id = id;
        CinemaRooms = cinemaRooms;
        this.maxGuests = maxGuests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCinemaRooms() {
        return CinemaRooms;
    }

    public void setCinemaRooms(String cinemaRooms) {
        CinemaRooms = cinemaRooms;
    }

    public String getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(String maxGuests) {
        this.maxGuests = maxGuests;
    }
}