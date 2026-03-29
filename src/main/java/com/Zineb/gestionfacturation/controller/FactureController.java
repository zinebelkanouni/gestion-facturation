package com.Zineb.gestionfacturation.controller;

import com.Zineb.gestionfacturation.entity.Facture;
import com.Zineb.gestionfacturation.service.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/factures")
@RequiredArgsConstructor
public class FactureController {

    private final FactureService factureService;

    @PostMapping
    public ResponseEntity<Facture> creerFacture(@RequestBody Facture facture) {
        return ResponseEntity.ok(factureService.creerFacture(facture));
    }

    @GetMapping
    public ResponseEntity<List<Facture>> getAllFactures() {
        return ResponseEntity.ok(factureService.getAllFactures());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
        return ResponseEntity.ok(factureService.getFactureById(id));
    }

    @PutMapping("/{id}/statut")
    public ResponseEntity<Facture> updateStatut(@PathVariable Long id,
                                                 @RequestParam Facture.Statut statut) {
        return ResponseEntity.ok(factureService.updateStatut(id, statut));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
        factureService.deleteFacture(id);
        return ResponseEntity.ok().build();
    }
}