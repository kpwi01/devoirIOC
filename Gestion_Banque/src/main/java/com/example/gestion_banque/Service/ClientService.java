package com.example.gestion_banque.Service;

import com.example.gestion_banque.Entites.Client;
import com.example.gestion_banque.Entites.ClientForm;
import com.example.gestion_banque.Entites.User;
import com.example.gestion_banque.Entites.UserRole;
import com.example.gestion_banque.Repositories.ClientRepository;
import com.example.gestion_banque.Repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
    }
    public boolean doesClientExist(Long clientId) {
        return clientRepository.existsById(clientId);
    }
    public Client createClient(ClientForm clientForm) {
        // Create a new Client entity based on the form
        Client client = new Client();
        client.setFirstName(clientForm.getFirstName());
        client.setLastName(clientForm.getLastName());
        client.setEmail(clientForm.getEmail());
        client.setPostalAddress(clientForm.getPostalAddress());

        // Save the client to the database
        return clientRepository.save(client);
    }

}
