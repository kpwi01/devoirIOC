package com.example.gestion_banque.Service;

import com.example.gestion_banque.Entites.BankAccount;
import com.example.gestion_banque.Entites.Transaction;
import com.example.gestion_banque.Entites.TransactionForm;
import com.example.gestion_banque.Exceptions.InsufficientFundsException;
import com.example.gestion_banque.Repositories.BankAccountRepository;
import com.example.gestion_banque.Repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public Transaction addTransaction(TransactionForm transactionForm) {
        // Créez une nouvelle transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionForm.getAmount());
        transaction.setType(transactionForm.getType());
        transaction.setMotif(transactionForm.getMotif());
        transaction.setDate(LocalDateTime.now());

        // Associez la transaction au compte bancaire
        BankAccount bankAccount = transactionForm.getBankAccount();
        transaction.setBankAccount(bankAccount);

        // Mettez à jour le solde du compte bancaire après la transaction
        updateBalanceAfterTransaction(bankAccount, transactionForm.getAmount(), transactionForm.getType());

        // Enregistrez la transaction
        return transactionRepository.save(transaction);
    }

    private void updateBalanceAfterTransaction(BankAccount bankAccount, BigDecimal amount, String type) {
        // Implémentez la logique de mise à jour du solde ici en fonction du type de transaction (débit, crédit)
        BigDecimal currentBalance = bankAccount.getBalance();

        if ("Débit".equals(type)) {
            if (currentBalance.compareTo(amount) >= 0) {
                bankAccount.setBalance(currentBalance.subtract(amount));
            } else {
                throw new InsufficientFundsException("Fonds insuffisants pour effectuer la transaction.");
            }
        } else if ("Crédit".equals(type)) {
            bankAccount.setBalance(currentBalance.add(amount));
        }

        // Enregistrez la mise à jour du solde du compte bancaire
        bankAccountRepository.save(bankAccount);
    }
}
