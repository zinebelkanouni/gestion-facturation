package com.Zineb.gestionfacturation.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "facture")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    private Double total;

    @Column(name = "devis_id")
    private Long devisId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public enum Statut {
        NON_PAYEE, PARTIELLEMENT_PAYEE, PAYEE
    }
}