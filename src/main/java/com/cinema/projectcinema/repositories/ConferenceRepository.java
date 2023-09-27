package com.cinema.projectcinema.repositories;

import com.cinema.projectcinema.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Integer> {
}
