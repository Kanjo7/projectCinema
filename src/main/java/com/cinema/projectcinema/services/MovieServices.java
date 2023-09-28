package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.Movie;
import com.cinema.projectcinema.exceptions.ResourceNotFoundException;
import com.cinema.projectcinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServices implements MovieServicesInterface {

    @Autowired
    private MovieRepository movieRepository;

    public MovieServices(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "Id", id));
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie, int id) {
        Movie m = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));

        m.setMovieTitle(movie.getMovieTitle());
        m.setMovieGenre(movie.getMovieGenre());
        m.setAgeLimit(movie.getAgeLimit());
        m.setMovieLength(movie.getMovieLength());

        movieRepository.save(m);

        return m;
    }
}
