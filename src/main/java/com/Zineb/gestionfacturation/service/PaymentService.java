package com.zineb.gestionfacturation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zineb.gestionfacturation.entity.Payment;
import com.zineb.gestionfacturation.entity.Facture;
import com.zineb.gestionfacturation.repository.PaymentRepository;
import com.zineb.gestionfacturation.repository.FactureRepository;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private FactureRepository factureRepository;

    public Payment addPayment(Payment payment){

        Facture facture = payment.getFacture();

        payment = paymentRepository.save(payment);

        // recalcul statut
        List<Payment> payments = facture.getPayments();

        double totalPaid = payments.stream().mapToDouble(Payment::getMontant).sum();

        if(totalPaid >= facture.getTotal()){
            facture.setStatut("PAYEE");
        } else if(totalPaid > 0){
            facture.setStatut("PARTIELLE");
        }

        factureRepository.save(facture);

        return payment;
    }
}