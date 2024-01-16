package com.example.gestion_banque.Service;

import com.example.gestion_banque.Entites.BankAccount;
import com.example.gestion_banque.Entites.BankAccountForm;
import com.example.gestion_banque.Entites.Client;
import com.example.gestion_banque.Repositories.BankAccountRepository;
import com.example.gestion_banque.Repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



    // Add other methods as needed
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private ClientRepository clientRepository; // Assuming you have a ClientRepository

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(Long accountId) {
        return bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Bank account not found with id: " + accountId));
    }

    public BankAccount addBankAccount(BankAccountForm bankAccountForm) {
        // Validate that the associated client exists
        Long clientId = bankAccountForm.getClientId();
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));

        BankAccount bankAccount = new BankAccount();
        bankAccount.setRib(bankAccountForm.getRIB());
        bankAccount.setClient(client);
        bankAccount.setStatus("Ouvert");

        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount updateBankAccount(Long accountId, BankAccountForm bankAccountForm) {
        BankAccount existingAccount = getBankAccountById(accountId);

        // Update fields based on the form
        existingAccount.setRib(bankAccountForm.getRIB());

        return bankAccountRepository.save(existingAccount);
    }

    public void deleteBankAccount(Long accountId) {
        bankAccountRepository.deleteById(accountId);
    }

    // Add other methods as needed

}

