package com.zineb.gestionfacturation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zineb.gestionfacturation.entity.Facture;
import com.zineb.gestionfacturation.service.FactureService;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @PostMapping
    public Facture create(@RequestBody Facture facture){
        return factureService.create(facture);
    }
}