package com.example.demo;

import com.example.demo.entities.Event;
import com.example.demo.repositories.EventRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    @Autowired
    private EventRepository eventRepository;
    
    public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        UUID userId = UUID.fromString("1124d9e8-6266-4bcf-8035-37a02ba75c69");

        // Créez un objet SimpleDateFormat pour formater la date et l'heure
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Spécifiez les dates et heures de début et de fin au format "yyyy-MM-dd HH:mm:ss"
        Date startDateTime = dateFormat.parse("2023-09-05 09:00:00"); // Par exemple, 5 septembre 2023 à 09:00:00
        Date endDateTime = dateFormat.parse("2023-09-05 11:30:00");   // Par exemple, 5 septembre 2023 à 11:30:00

        List<String> imagesList = new ArrayList<String>();
        
        eventRepository.save(new Event(null, userId, "Event 1", "Desc Event 1", "Sacre-coeur II", imagesList, startDateTime, endDateTime, new Date(), new Date()));
        eventRepository.save(new Event(null, userId, "Event 2", "Desc Event 2", "Liberte 6", imagesList, startDateTime, endDateTime, new Date(), new Date()));
        
    }

}

