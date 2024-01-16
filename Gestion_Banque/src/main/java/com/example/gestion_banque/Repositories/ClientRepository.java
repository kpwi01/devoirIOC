package com.example.gestion_banque.Repositories;

import com.example.gestion_banque.Entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
