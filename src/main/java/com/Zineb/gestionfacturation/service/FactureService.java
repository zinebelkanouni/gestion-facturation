package com.Zineb.gestionfacturation.service;

import com.Zineb.gestionfacturation.entity.Facture;
import com.Zineb.gestionfacturation.repository.FactureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureService {

    private final FactureRepository factureRepository;

    public Facture creerFacture(Facture facture) {
        facture.setReference("FAC-" + System.currentTimeMillis());
        facture.setStatut(Facture.Statut.NON_PAYEE);
        facture.setCreatedAt(LocalDateTime.now());
        return factureRepository.save(facture);
    }

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(Long id) {
        return factureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facture introuvable"));
    }

    public Facture updateStatut(Long id, Facture.Statut statut) {
        Facture facture = getFactureById(id);
        facture.setStatut(statut);
        return factureRepository.save(facture);
    }

    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }
}