package com.example.gestion_banque.Web;

import com.example.gestion_banque.Entites.BankAccount;
import com.example.gestion_banque.Entites.BankAccountForm;
import com.example.gestion_banque.Service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bank-accounts")
@CrossOrigin(value = "localhost:4200")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/get_bank")
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
        return ResponseEntity.ok(bankAccounts);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Long accountId) {
        BankAccount bankAccount = bankAccountService.getBankAccountById(accountId);
        return ResponseEntity.ok(bankAccount);
    }

    @PostMapping("/add")
    public ResponseEntity<BankAccount> createBankAccount(@Valid @RequestBody BankAccountForm bankAccountForm) {
        BankAccount createdBankAccount = bankAccountService.addBankAccount(bankAccountForm);
        return ResponseEntity.ok(createdBankAccount);
    }

    // Add other methods as needed
}
