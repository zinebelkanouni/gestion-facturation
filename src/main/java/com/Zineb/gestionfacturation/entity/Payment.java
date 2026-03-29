package com.Zineb.gestionfacturation.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;

    @Column(name = "date_payment")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;
}