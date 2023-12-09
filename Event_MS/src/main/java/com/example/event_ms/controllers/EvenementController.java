package com.example.event_ms.controllers;


import com.example.event_ms.entities.Evenement;
import com.example.event_ms.services.FileStorageService;
import com.example.event_ms.services.IEvenementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EvenementController {
    IEvenementService eventService;
    @Autowired
    FileStorageService fileStorageService ;
    @PostMapping("/addEvent")
    Evenement addEvent (@ModelAttribute Evenement evenement, @RequestParam(value = "file",required = false) MultipartFile imageFile){
        String imageUrl = fileStorageService.storeFile(imageFile);
        evenement.setImageEvent(imageUrl);

        return eventService.addEvent(evenement,imageFile);
    }

    @GetMapping("/getOneEvent/{id}")
    Evenement getEvent(@PathVariable Long id){
        return eventService.getEvent(id);
    }

    @GetMapping("/events")
    List<Evenement> getAllEvent(){
        return eventService.getAllEvents();
    }

    @DeleteMapping("/deleteEvent/{id}")
    void deleteEvent(@PathVariable Long id){
        this.eventService.deleteEvent(id);
    }

    @PatchMapping("/updateEvent")
    public Evenement updateEvent(@ModelAttribute Evenement evenement, @RequestParam(value = "file", required = false) MultipartFile imageFile) {
        if (imageFile != null){
            String image = fileStorageService.storeFile(imageFile);
            evenement.setImageEvent(image); }
        if (imageFile == null){
            evenement.setImageEvent(evenement.getImageEvent()); }
        return eventService.updateEvent(evenement,imageFile);
    }


    @PostMapping("/events/shareFb/{id}")
    public String shareFb(@PathVariable Long id){
        return eventService.shareFb(id);
    }

}