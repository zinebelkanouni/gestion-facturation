package com.zineb.gestionfacturation.entity;

import jakarta.persistence.*;

@Entity
public class DevisLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int quantite;
    private double prix;
    private double tva;

    private double total;

    @ManyToOne
    private Devis devis;

    // getters setters
    public Long getId() { return id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public double getTva() { return tva; }
    public void setTva(double tva) { this.tva = tva; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Devis getDevis() { return devis; }
    public void setDevis(Devis devis) { this.devis = devis; }
}