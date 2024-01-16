package com.example.gestion_banque;

import com.example.gestion_banque.Entites.User;
import com.example.gestion_banque.Entites.UserRole;
import com.example.gestion_banque.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class GestionBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionBanqueApplication.class, args);
    }


}
