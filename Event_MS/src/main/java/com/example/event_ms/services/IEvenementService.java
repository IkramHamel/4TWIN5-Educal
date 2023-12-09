package com.example.event_ms.services;

import com.example.event_ms.entities.Evenement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IEvenementService {
    Evenement addEvent(Evenement event , MultipartFile imageFile);

    Evenement getEvent(Long idEvent);

    List<Evenement> getAllEvents();

    void deleteEvent(Long idEvent);

    Evenement updateEvent(Evenement event, MultipartFile imageFile);

    Evenement handleImageFileUpload(MultipartFile fileImage, long id);

    String shareFb(Long id);
}

