package com.cinema.projectcinema.entities;

import javax.persistence.*;

@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String conferenceName;

    public Conference() {
    }

    public Conference(int id, String conferenceName) {
        this.id = id;
        this.conferenceName = conferenceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }
}
