package com.zineb.gestionfacturation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zineb.gestionfacturation.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}