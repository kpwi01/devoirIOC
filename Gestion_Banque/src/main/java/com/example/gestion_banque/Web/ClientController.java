package com.example.gestion_banque.Web;

import com.example.gestion_banque.Entites.Client;
import com.example.gestion_banque.Entites.ClientForm;
import com.example.gestion_banque.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

// ClientController
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/get")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        Client client = clientService.getClientById(clientId);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientForm clientForm) {
        Client createdClient = clientService.createClient(clientForm);
        return ResponseEntity.ok(createdClient);
    }
    @GetMapping("/check/{clientId}")
    public ResponseEntity<Boolean> checkClientExists(@PathVariable Long clientId) {
        boolean clientExists = clientService.doesClientExist(clientId);
        return ResponseEntity.ok(clientExists);
    }
    // Add other methods as needed
}



