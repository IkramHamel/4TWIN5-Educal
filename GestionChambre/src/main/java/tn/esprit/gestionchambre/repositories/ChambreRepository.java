package tn.esprit.gestionchambre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionchambre.entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
}