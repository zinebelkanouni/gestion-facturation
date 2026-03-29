package com.Zineb.gestionfacturation.repository;

import com.Zineb.gestionfacturation.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByFactureId(Long factureId);
}