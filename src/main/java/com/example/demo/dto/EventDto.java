/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.entities.Event;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.Data;


/**
 *
 * @author user
 */

@Data
public class EventDto {
    private String userId;
    private String title;
    private String description;
    private String address;
    private List<String> images;
    
    @JsonFormat(pattern = "HH:mm")
    private Date startTime;
    @JsonFormat(pattern = "HH:mm")
    private Date endTime;
    
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedDate;
    
    
    // Méthode de conversion de DTO à Entité
    public Event toEntity() {
        Event event = new Event();
        try {
            // Gestion de la conversion de String en UUID
            UUID uuid = UUID.fromString(this.userId);
            event.setUserId(uuid);
        } catch (IllegalArgumentException e) {
            // Gérez l'erreur ici, par exemple, en lançant une exception personnalisée
            throw new IllegalArgumentException("Invalid userId format");
        }
//        event.setUserId(UUID.fromString(this.userId));
        event.setTitle(this.title);
        event.setDescription(this.description);
        event.setAddress(this.address);
        event.setImages(this.images);
        event.setStartTime(this.startTime);
        event.setEndTime(this.endTime);
        event.setCreatedDate(this.createdDate);
        event.setUpdatedDate(this.updatedDate);
        return event;
    }
    
    // Méthode de conversion d'Entité à DTO
    public static EventDto fromEntity(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setUserId(event.getUserId().toString());
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setAddress(event.getAddress());
        eventDto.setImages(event.getImages());
        
        eventDto.setStartTime(event.getStartTime());
        eventDto.setEndTime(event.getEndTime()); 
    
        eventDto.setCreatedDate(event.getCreatedDate());
        eventDto.setUpdatedDate(event.getUpdatedDate());
        return eventDto;
    }
}