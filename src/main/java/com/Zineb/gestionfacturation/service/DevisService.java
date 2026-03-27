package com.zineb.gestionfacturation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.zineb.gestionfacturation.entity.Devis;
import com.zineb.gestionfacturation.entity.DevisLine;
import com.zineb.gestionfacturation.repository.DevisRepository;

@Service
public class DevisService {

    @Autowired
    private DevisRepository devisRepository;

    public Devis save(Devis devis){

        double totalHT = 0;
        double totalTVA = 0;

        for(DevisLine l : devis.getLignes()){

            double ht = l.getPrix() * l.getQuantite();
            double tva = ht * (l.getTva() / 100);

            l.setTotal(ht + tva);
            l.setDevis(devis);

            totalHT += ht;
            totalTVA += tva;
        }

        devis.setTotalHT(totalHT);
        devis.setTotalTVA(totalTVA);
        devis.setTotalTTC(totalHT + totalTVA);

        return devisRepository.save(devis);
    }

    public List<Devis> getAll(){
        return devisRepository.findAll();
    }
}