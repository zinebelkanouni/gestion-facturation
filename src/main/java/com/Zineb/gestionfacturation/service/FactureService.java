package com.zineb.gestionfacturation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zineb.gestionfacturation.entity.Facture;
import com.zineb.gestionfacturation.repository.FactureRepository;

import java.util.UUID;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    public Facture create(Facture facture){

        // générer référence
        facture.setReference("FAC-" + UUID.randomUUID().toString());

        // total = total devis
        facture.setTotal(facture.getDevis().getTotalTTC());

        // statut initial
        facture.setStatut("NON_PAYEE");

        return factureRepository.save(facture);
    }
}