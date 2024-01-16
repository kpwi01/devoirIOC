package com.example.gestion_banque.Entites;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private String type; // "Débit" ou "Crédit"
    private String motif;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;


    public Transaction() {
    }

    public Transaction(Long id, BigDecimal amount, String type, String motif, LocalDateTime date, BankAccount bankAccount) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.motif = motif;
        this.date = date;
        this.bankAccount = bankAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
