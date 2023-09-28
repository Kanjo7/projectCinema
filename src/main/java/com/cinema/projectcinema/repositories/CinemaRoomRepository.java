package com.cinema.projectcinema.repositories;

import com.cinema.projectcinema.entities.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer> {
}
