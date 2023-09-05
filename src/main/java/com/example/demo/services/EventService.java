package com.example.demo.services;

import com.example.demo.entities.Event;
import com.example.demo.repositories.EventRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/events")
public class EventService {
    
    @Autowired
    private final EventRepository eventRepository;
    
    
    public EventService(EventRepository _eventRepository) {
        this.eventRepository = _eventRepository;
    }   

    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

}


