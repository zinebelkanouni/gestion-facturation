package com.zineb.gestionfacturation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.zineb.gestionfacturation.entity.Devis;
import com.zineb.gestionfacturation.service.DevisService;

@RestController
@RequestMapping("/api/devis")
public class DevisController {

    @Autowired
    private DevisService devisService;

    @PostMapping
    public Devis create(@RequestBody Devis devis){
        return devisService.save(devis);
    }

    @GetMapping
    public List<Devis> getAll(){
        return devisService.getAll();
    }
}