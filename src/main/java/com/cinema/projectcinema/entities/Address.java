package com.cinema.projectcinema.entities;

import javax.persistence.*;

import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String street;

    @Column(length = 45)
    private int postalCode;

    @Column(length = 45)
    private String city;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customer;

    public Address() {
    }

    public Address(int id, String street, int postalCode, String city, List<Customer> customer) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}