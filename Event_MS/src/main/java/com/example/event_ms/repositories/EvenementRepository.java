package com.example.event_ms.repositories;

import com.example.event_ms.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
}
