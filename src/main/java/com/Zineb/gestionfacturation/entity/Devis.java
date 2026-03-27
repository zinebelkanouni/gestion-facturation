package com.zineb.gestionfacturation.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statut; // BROUILLON, ENVOYE, ACCEPTE...

    private double totalHT;
    private double totalTVA;
    private double totalTTC;

    // relation avec client
    @ManyToOne
    private Client client;

    // relation avec lignes
    @OneToMany(mappedBy = "devis", cascade = CascadeType.ALL)
    private List<DevisLine> lignes;

    // getters setters
    public Long getId() { return id; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public double getTotalHT() { return totalHT; }
    public void setTotalHT(double totalHT) { this.totalHT = totalHT; }

    public double getTotalTVA() { return totalTVA; }
    public void setTotalTVA(double totalTVA) { this.totalTVA = totalTVA; }

    public double getTotalTTC() { return totalTTC; }
    public void setTotalTTC(double totalTTC) { this.totalTTC = totalTTC; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<DevisLine> getLignes() { return lignes; }
    public void setLignes(List<DevisLine> lignes) { this.lignes = lignes; }
}