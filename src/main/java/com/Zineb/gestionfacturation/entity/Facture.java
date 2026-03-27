package com.zineb.gestionfacturation.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    private String statut; // NON_PAYEE, PARTIELLE, PAYEE

    private double total;

    @OneToOne
    private Devis devis;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private List<Payment> payments;

    // getters setters
    public Long getId() { return id; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Devis getDevis() { return devis; }
    public void setDevis(Devis devis) { this.devis = devis; }

    public List<Payment> getPayments() { return payments; }
    public void setPayments(List<Payment> payments) { this.payments = payments; }
}