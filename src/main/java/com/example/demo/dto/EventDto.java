/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;


/**
 *
 * @author user
 */

@Data
@Builder
public class EventDto {
    private String userId;
    private String title;
    private String description;
    private String address;
    private List<String> images;
}