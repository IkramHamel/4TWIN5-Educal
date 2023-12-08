package tn.esprit.gestionchambre.service;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.gestionchambre.entities.Chambre;

import java.util.List;

public interface IChambreService {
   // Chambre addChambre(Chambre chambre,MultipartFile imageFile);
   Chambre addChambre(Chambre chambre);

    Chambre getChambre(Long id);

    List<Chambre> getAllChambres();

    void deleteChambre(long idChambre);

//    Chambre updateChambre(Chambre chambre,MultipartFile imageFile);
    Chambre updateChambre(Chambre chambre);
  //  public Chambre handleImageFileUpload(MultipartFile fileImage, long id) ;
}


