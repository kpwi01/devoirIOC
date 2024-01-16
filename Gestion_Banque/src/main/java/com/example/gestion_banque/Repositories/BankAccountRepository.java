package com.example.gestion_banque.Repositories;

import com.example.gestion_banque.Entites.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
