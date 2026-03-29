package com.Zineb.gestionfacturation.repository;

import com.Zineb.gestionfacturation.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    List<Facture> findByStatut(Facture.Statut statut);
    List<Facture> findByDevisId(Long devisId);
}