package com.Zineb.gestionfacturation.service;

import com.Zineb.gestionfacturation.entity.Facture;
import com.Zineb.gestionfacturation.entity.Payment;
import com.Zineb.gestionfacturation.repository.FactureRepository;
import com.Zineb.gestionfacturation.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final FactureRepository factureRepository;

    public Payment addPayment(Long factureId, Double montant) {

        Facture facture = factureRepository.findById(factureId)
                .orElseThrow(() -> new RuntimeException("Facture introuvable"));

        // créer paiement
        Payment payment = new Payment();
        payment.setMontant(montant);
        payment.setDate(LocalDateTime.now());
        payment.setFacture(facture);

        paymentRepository.save(payment);

        // calcul total payé
        List<Payment> payments = paymentRepository.findByFactureId(factureId);

        double totalPaye = payments.stream()
                .mapToDouble(Payment::getMontant)
                .sum();

        // update statut facture
        if (totalPaye == 0) {
            facture.setStatut(Facture.Statut.NON_PAYEE);
        } else if (totalPaye < facture.getTotal()) {
            facture.setStatut(Facture.Statut.PARTIELLEMENT_PAYEE);
        } else {
            facture.setStatut(Facture.Statut.PAYEE);
        }

        factureRepository.save(facture);

        return payment;
    }
}