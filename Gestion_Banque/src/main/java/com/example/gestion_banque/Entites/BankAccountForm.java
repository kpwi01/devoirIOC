package com.example.gestion_banque.Entites;
import javax.validation.constraints.NotBlank;


public class BankAccountForm {
    @NotBlank(message = "Le RIB est obligatoire.")
    private String RIB;

    private Long clientId; // Supposons que vous ayez besoin de lier le compte bancaire à un client

    // Constructeurs, getters, setters...

    // Exemple de constructeur
    public BankAccountForm(String RIB, Long clientId) {
        this.RIB = RIB;
        this.clientId = clientId;
    }

    // Getters et setters
    public String getRIB() {
        return RIB;
    }

    public void setRIB(String RIB) {
        this.RIB = RIB;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
