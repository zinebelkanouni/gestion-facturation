package com.zineb.gestionfacturation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zineb.gestionfacturation.entity.Devis;

public interface DevisRepository extends JpaRepository<Devis, Long> {
}