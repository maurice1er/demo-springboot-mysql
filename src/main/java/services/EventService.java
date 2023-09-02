package services;

import com.example.demo.entities.Event;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repositories.EventRepository;

@Service 
public class EventService {
    
    private final EventRepository eventRepository;
    
    @Autowired
    public EventService(EventRepository _eventRepository) {
        this.eventRepository = _eventRepository;
    }
    
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    
}
