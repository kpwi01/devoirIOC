package com.example.gestion_banque.Web;

import com.example.gestion_banque.Entites.Transaction;
import com.example.gestion_banque.Entites.TransactionForm;
import com.example.gestion_banque.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(value = "localhost:4200")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/add")
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionForm transactionForm) {
        Transaction createdTransaction = transactionService.addTransaction(transactionForm);
        return ResponseEntity.ok(createdTransaction);
    }

    // Add other methods as needed
}