package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.Conference;
import com.cinema.projectcinema.exceptions.ResourceNotFoundException;
import com.cinema.projectcinema.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceServices {

    @Autowired
    private ConferenceRepository conferenceRepository;

    public ConferenceServices(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public Conference saveConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public void deleteConference(int id) {
        conferenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conference", "Id", id));
        conferenceRepository.deleteById(id);
    }

    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }


    public Conference updateConference(Conference conference, int id) {
        Conference c = conferenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conference", "id", id));
        c.setConferenceName(conference.getConferenceName());

        conferenceRepository.save(c);

        return c;
    }
}
