package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.CinemaRoom;
import com.cinema.projectcinema.exceptions.ResourceNotFoundException;
import com.cinema.projectcinema.repositories.CinemaRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaRoomServices implements CinemaRoomServicesInterface {

    @Autowired
    private CinemaRoomRepository cinemaRoomRepository;


    public CinemaRoomServices(CinemaRoomRepository cinemaRoomRepository) {
        this.cinemaRoomRepository = cinemaRoomRepository;
    }

    @Override
    public CinemaRoom saveCinemaRoom(CinemaRoom cinemaRoom) {
        return cinemaRoomRepository.save(cinemaRoom);
    }

    @Override
    public void deleteCinemaRoom(int id) {
        cinemaRoomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CinemaRoom", "Id", id));
        cinemaRoomRepository.deleteById(id);
    }

    @Override
    public List<CinemaRoom> getAllCinemaRooms() {
        return cinemaRoomRepository.findAll();
    }

    @Override
    public CinemaRoom updateCinemaRoom(CinemaRoom cinemaRoom, int id) {
        CinemaRoom c = cinemaRoomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CinemaRoom", "id", id));
        c.setCinemaRooms(cinemaRoom.getCinemaRooms());

        cinemaRoomRepository.save(c);

        return c;
    }
}
