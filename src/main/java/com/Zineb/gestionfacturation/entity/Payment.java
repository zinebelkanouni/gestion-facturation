package com.zineb.gestionfacturation.entity;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;

    @ManyToOne
    private Facture facture;

    // getters setters
    public Long getId() { return id; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public Facture getFacture() { return facture; }
    public void setFacture(Facture facture) { this.facture = facture; }
}