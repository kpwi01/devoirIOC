package com.example.gestion_banque.Entites;

import java.math.BigDecimal;

public class TransactionForm {
    private BigDecimal amount;
    private String type; // "Débit" ou "Crédit"
    private String motif;
    private BankAccount bankAccount;

    public TransactionForm(BigDecimal amount, String type, String motif, BankAccount bankAccount) {
        this.amount = amount;
        this.type = type;
        this.motif = motif;
        this.bankAccount = bankAccount;
    }

    public TransactionForm() {
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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
