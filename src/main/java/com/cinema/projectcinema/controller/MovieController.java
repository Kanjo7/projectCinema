package com.cinema.projectcinema.controller;

import com.cinema.projectcinema.entities.Movie;
import com.cinema.projectcinema.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class MovieController {

    public static final Logger logger = Logger.getLogger("MovieController.class");

    @Autowired
    MovieServices movieServices;

    @PostMapping("/api/v4/add-movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        logger.info("New Movie added by Admin");

        return new ResponseEntity<>(movieServices.saveMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping("/api/v4/movies")
    public List<Movie> getAllMovies() {
        logger.info("Showing all Movies to customer");

        return movieServices.getAllMovies();
    }

    @PutMapping("/api/v4/updatemovie")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") int id, @RequestBody Movie movie) {
        logger.info("Movie updated!");

        return ResponseEntity.ok(movieServices.updateMovie(movie, id));
    }

    @DeleteMapping("/api/deletemovie/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {
        movieServices.deleteMovie(id);
        logger.info("Movie deleted by Admin!");

        return new ResponseEntity<String>("Movie deleted!", HttpStatus.OK);
    }
}
