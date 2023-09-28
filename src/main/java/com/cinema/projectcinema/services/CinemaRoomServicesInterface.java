package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.CinemaRoom;

import java.util.List;

public interface CinemaRoomServicesInterface {

    CinemaRoom saveCinemaRoom(CinemaRoom cinemaRoom);

    List<CinemaRoom> getAllCinemaRooms();

    CinemaRoom updateCinemaRoom(CinemaRoom cinemaRoom, int id);

    void deleteCinemaRoom(int id);
}
