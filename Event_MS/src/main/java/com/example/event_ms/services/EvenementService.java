package com.example.event_ms.services;

import com.example.event_ms.entities.Evenement;
import com.example.event_ms.repositories.EvenementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import java.util.List;

@Service
@AllArgsConstructor
public class EvenementService implements IEvenementService {

    EvenementRepository evenementRepository;
    FileStorageService fileStorageService;

    @Transactional
    @Override
    public Evenement addEvent(Evenement event, MultipartFile imageFile){
        String imageUrl = fileStorageService.storeFile(imageFile);
        event.setImageEvent(imageUrl);
            return evenementRepository.save(event);

    }

    @Override
    public Evenement getEvent(Long idEvent){
        return this.evenementRepository.findById(idEvent).orElse(null);
    }

    @Override
    public List<Evenement> getAllEvents(){
        return this.evenementRepository.findAll();
    }

    @Override
    public void deleteEvent(Long idEvent){
        this.evenementRepository.deleteById(idEvent);
    }
    @Override
    public Evenement updateEvent(Evenement evenement, MultipartFile imageFile) {
        Evenement event = evenementRepository.findById(evenement.getIdEvent()).orElse(null);
        if (event != null) {
            if (imageFile != null && !imageFile.isEmpty()) {
                String image = fileStorageService.storeFile(imageFile);
                event.setImageEvent(image);
            } else {
                evenement.setImageEvent(event.getImageEvent());
            }

            evenementRepository.save(evenement);
        }
        return event;
    }


    public Evenement handleImageFileUpload(MultipartFile fileImage, long id) {
        if (fileImage.isEmpty()) {
            return null;
        }
        String fileName = fileStorageService.storeFile(fileImage);
        Evenement event = evenementRepository.findById(id).orElse(null);
        event.setImageEvent(fileName);
        return evenementRepository.save(event);
    }

    @Override
    public String shareFb(Long id){
        String appId = "232528662540085";
        String appSecret = "60988e9928012f06c205e07717bb4196";
        String accessTokenString = "EAADTe8xUrzUBO40o6y4BTyuaHJuPXx5ZCWJsLCUVnEPIFBt2QUhbshwDnNEN6qbavLEpgt9XhjfGCX5ZBQwMjjE6d1lvXZCKldKhoNKZCD1NpZC5B3oikUbuk91Ry0pzV5ZBUCvmOTzeZCbukXTekO7LnUSmTIZC9EXCP1H7MxomKUWGlMcDsbrwzE3guxGHrXAxGIJMsKwOAhTXmHfszaWslyUj";

        // Set up Facebook4J
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId(appId, appSecret);
        facebook.setOAuthAccessToken(new AccessToken(accessTokenString, null));

        // Post a status message
        Evenement event = evenementRepository.findById(id).orElse(null);

        String message = "New Event is coming !!" + "\n"+ event.getNomEvent() + "\n" + event.getLieuEvent()+ "\n" +event.getDateDebEvent()+ "\n" +event.getDateFinEvent();
        try {
            facebook.postStatusMessage(message);
            return "Status message posted successfully.";
        } catch (FacebookException e) {
            e.printStackTrace();
            System.err.println("Error posting status message: " + e.getMessage());
            return  "Erreur";
        }
    }
}