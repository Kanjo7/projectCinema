package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.Movie;

import java.util.List;

public interface MovieServicesInterface {

    Movie saveMovie(Movie movie);

    List<Movie> getAllMovies();

    Movie updateMovie(Movie movie, int id);

    void deleteMovie(int id);
}
