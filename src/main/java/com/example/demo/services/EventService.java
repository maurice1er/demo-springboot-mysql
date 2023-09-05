package com.example.demo.services;

import com.example.demo.dto.EventDto;
import com.example.demo.entities.Event;
import com.example.demo.repositories.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    
    @PostMapping
    public Event createEvent(@RequestBody EventDto eventDto) {
        // Convertissez le DTO en entité
        Event event = eventDto.toEntity();

        // Enregistrez l'entité dans la base de données
        event = eventRepository.save(event);

        // Vous pouvez retourner l'entité si nécessaire, ou convertir en DTO pour la réponse
        return event;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findEventById(@PathVariable Long id) {
        try {
            // Récupérez l'événement par son ID
            Optional<Event> eventOptional = eventRepository.findById(id);

            if (eventOptional.isPresent()) {
                Event event = eventOptional.get();
                EventDto eventDto = EventDto.fromEntity(event);

                // Si l'événement est trouvé, renvoyez une réponse 200 (OK) avec le corps de l'événement
                return ResponseEntity.status(HttpStatus.OK).body(eventDto);
            } else {
                // Si l'événement n'est pas trouvé, renvoyez une réponse 404 (Not Found) avec un message d'erreur
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Événement non trouvé avec l'ID : " + id);
            }
        } catch (Exception e) {
            // En cas d'erreur interne du serveur, renvoyez une réponse 500 (Internal Server Error) avec un message d'erreur
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur interne du serveur : " + e.getMessage());
        }
    }

}


