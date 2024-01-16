package com.example.gestion_banque.Repositories;

import com.example.gestion_banque.Entites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
