package com.zineb.gestionfacturation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zineb.gestionfacturation.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}