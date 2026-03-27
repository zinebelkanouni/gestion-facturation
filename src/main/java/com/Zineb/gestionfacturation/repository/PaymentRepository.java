package com.zineb.gestionfacturation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zineb.gestionfacturation.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}