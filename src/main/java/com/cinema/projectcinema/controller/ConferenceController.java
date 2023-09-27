package com.cinema.projectcinema.controller;

import com.cinema.projectcinema.services.ConferenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class ConferenceController {

    public static final Logger logger = Logger.getLogger("ConferenceController.class");

    @Autowired
    ConferenceServices conferenceServices;

}
