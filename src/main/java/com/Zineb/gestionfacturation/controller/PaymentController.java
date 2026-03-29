package com.Zineb.gestionfacturation.controller;

import com.Zineb.gestionfacturation.entity.Payment;
import com.Zineb.gestionfacturation.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Payment addPayment(@RequestParam Long factureId,
                              @RequestParam Double montant) {

        return paymentService.addPayment(factureId, montant);
    }
}