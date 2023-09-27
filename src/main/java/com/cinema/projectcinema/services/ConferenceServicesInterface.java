package com.cinema.projectcinema.services;

import com.cinema.projectcinema.entities.Conference;

import java.util.List;

public interface ConferenceServicesInterface {

    Conference saveConference(Conference conference);

    List<Conference> getAllConferences();

    Conference updateConference(Conference conference, int id);

    void deleteConference(int id);
}
