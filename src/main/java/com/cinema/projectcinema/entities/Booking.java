package com.cinema.projectcinema.entities;


import javax.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private int guestsInRoom;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinemaRoomId")
    private CinemaRoom cinemaRoom;

    @Column(length = 45)
    private boolean speaker;

    @Column(length = 45)
    private double price;

    @Transient
    private double priceInEuro;

    public Booking() {
    }

    public Booking(int id, int guestsInRoom, Customer customer, CinemaRoom cinemaRoom, boolean speaker, double price, double priceInEuro) {
        this.id = id;
        this.guestsInRoom = guestsInRoom;
        this.customer = customer;
        this.cinemaRoom = cinemaRoom;
        this.speaker = speaker;
        this.price = price;
        this.priceInEuro = priceInEuro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuestsInRoom() {
        return guestsInRoom;
    }

    public void setGuestsInRoom(int guestsInRoom) {
        this.guestsInRoom = guestsInRoom;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public boolean isSpeaker() {
        return speaker;
    }

    public void setSpeaker(boolean speaker) {
        this.speaker = speaker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(double priceInEuro) {
        this.priceInEuro = priceInEuro;
    }
}
