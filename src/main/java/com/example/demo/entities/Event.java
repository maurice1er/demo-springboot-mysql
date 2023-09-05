package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table; 
import java.io.Serializable; 
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor; 

/**
 *
 * @author user
 */

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name = "events")
public class Event implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @Column(name = "userId", nullable = false, columnDefinition = "BINARY(16)")
    @Column(name = "userId", nullable = false)
    private UUID userId;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    private String description;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @ElementCollection
    @CollectionTable(name = "eventImages", joinColumns = @JoinColumn(name = "eventId"))
    @Column(name = "image", nullable = true)
    private List<String> images;
    
    @JsonFormat(pattern = "HH:mm")
    @Column(name = "startTime", nullable = false) // Heure de début
    private Date startTime;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "endTime", nullable = false) // Heure de fin
    private Date endTime;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "createdDate", nullable = false)
    private Date createdDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updatedDate", nullable = true)
    private Date updatedDate;
    
    
    @PrePersist
    protected void onCreate() {
        if (updatedDate == null) {
            updatedDate = new Date();
        }
    }
    
}