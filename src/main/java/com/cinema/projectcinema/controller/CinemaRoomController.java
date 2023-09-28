package com.cinema.projectcinema.controller;

import com.cinema.projectcinema.entities.CinemaRoom;
import com.cinema.projectcinema.services.CinemaRoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class CinemaRoomController {

    public static final Logger logger = Logger.getLogger("CinemaRoomController.class");

    @Autowired
    CinemaRoomServices cinemaRoomServices;

    @PostMapping("/api/v4/bookroom")
    public ResponseEntity<CinemaRoom> saveCinemaRoom(@RequestBody CinemaRoom cinemaRoom) {
        logger.info("User booked a room");

        return new ResponseEntity<>(cinemaRoomServices.saveCinemaRoom(cinemaRoom), HttpStatus.CREATED);
    }

    @PutMapping("/api/v4/updateroom")
    public ResponseEntity<CinemaRoom> updateCinemaRoom(@PathVariable("id") int id, @RequestBody CinemaRoom cinemaRoom) {
        logger.info("Room updated by Admin!");

        return ResponseEntity.ok(cinemaRoomServices.updateCinemaRoom(cinemaRoom, id));
    }
}
