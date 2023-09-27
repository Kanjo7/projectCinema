package com.cinema.projectcinema.repositories;

import com.cinema.projectcinema.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
