package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author user
 */

@Setter
@Getter
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "userId", nullable = false)
    private String userId;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    private String description;
    
    @Column(name = "address", nullable = false)
    private String address;
    
//    @ElementCollection
//    @CollectionTable(name = "eventImages", joinColumns = @JoinColumn(name = "eventId"))
//    @Column(name = "image")
//    private List<String> images;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private LocalDateTime createdDate;
    
    @UpdateTimestamp 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    private LocalDateTime updatedDate;
    
}