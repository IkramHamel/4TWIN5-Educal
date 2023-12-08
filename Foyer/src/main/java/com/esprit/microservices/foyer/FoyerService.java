package com.esprit.microservices.foyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerService {
    @Autowired
    private FoyerRepository foyerRepository;
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
    public List<Foyer> getFoyer(){
        return foyerRepository.findAll();
    }

    public Foyer updateFoyer(long id, Foyer newFoyer) {
        if (foyerRepository.findById(id).isPresent()) {
            Foyer existingFoyer = foyerRepository.findById(id).get();
            existingFoyer.setNomFoyer(newFoyer.getNomFoyer());
            existingFoyer.setCapacityFoyer(newFoyer.getCapacityFoyer());
          
            return foyerRepository.save(existingFoyer);
        } else
            return null;
    }
    public String deleteFoyer(long id) {
        if (foyerRepository.findById(id).isPresent()) {
            foyerRepository.deleteById(id);
            return "Foyer supprimé";
        } else
            return "Foyer non supprimé";
    }
}