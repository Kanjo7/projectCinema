package com.cinema.projectcinema.entities;


import javax.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private int eventRoom;

    @Column(length = 45)
    private int maxGuestsInRoom;

    @Column(length = 45)
    private double totalCost;

    public Booking() {
    }

    public Booking(int id, int eventRoom, int maxGuestsInRoom, double totalCost) {
        this.id = id;
        this.eventRoom = eventRoom;
        this.maxGuestsInRoom = maxGuestsInRoom;
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventRoom() {
        return eventRoom;
    }

    public void setEventRoom(int eventRoom) {
        this.eventRoom = eventRoom;
    }

    public int getMaxGuestsInRoom() {
        return maxGuestsInRoom;
    }

    public void setMaxGuestsInRoom(int maxGuestsInRoom) {
        this.maxGuestsInRoom = maxGuestsInRoom;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
