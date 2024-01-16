package com.example.gestion_banque.Web;

import com.example.gestion_banque.Entites.LoginRequest;
import com.example.gestion_banque.Service.UserService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(value = "localhost:4200")

public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        //String token = String.valueOf(userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword()));

        Map<String, String> token = userService.authenticateUser2(loginRequest.getUsername(), loginRequest.getPassword());
        if (token != null) {
            Map<String, String> response = new HashMap<>();
            //response.put("role", token);
            response.put("role", token.get("role"));
            response.put("id", token.get("id"));
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @GetMapping("/checkUserExists/{userId}")
    public ResponseEntity<Boolean> doesUserExist(@PathVariable Long userId) {
        boolean userExists = userService.doesUserExist(userId);
        return ResponseEntity.ok(userExists);
    }
}


