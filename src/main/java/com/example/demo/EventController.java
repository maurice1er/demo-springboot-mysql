package com.example.demo;

import com.example.demo.entities.Event;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.EventService;


@RestController
@RequestMapping("/api/events")
public class EventController {
    
    private final EventService eventService;
    
    @Autowired
    public EventController(EventService _eventService) {
        this.eventService = _eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

}


