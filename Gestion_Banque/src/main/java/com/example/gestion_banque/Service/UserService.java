package com.example.gestion_banque.Service;

import com.example.gestion_banque.Entites.User;
import com.example.gestion_banque.Entites.UserRole;
import com.example.gestion_banque.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserRole authenticateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        return user.map(User::getRole).orElse(null);
    }
    public boolean doesUserExist(Long userId) {
        return userRepository.existsById(userId);
    }

    public Map<String, String > authenticateUser2(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if(user.isPresent()){
            Map<String, String> res = new HashMap<>();
            res.put("role", user.get().getRole().name());
            res.put("id", ""+user.get().getId());
            return res;
        }

        return null;
    }



}
