package org.example.service;

import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private final Map<String, String> users = new HashMap<>(); // Stockage des utilisateurs (id : password)
    private final Map<String, String> tokens = new HashMap<>(); // Stockage des tokens (id : token)

    public AuthService() {
        // Ajout de quelques utilisateurs fictifs
        users.put("user1", "password1");
        users.put("admin", "admin123");
    }

    public String authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            String token = generateToken(username);
            tokens.put(username, token);
            return token;
        }
        return null;
    }

    private String generateToken(String username) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
        String timestamp = formatter.format(new Date());
        return username + "-" + timestamp;
    }

    public boolean validateToken(String username, String token) {
        return tokens.containsKey(username) && tokens.get(username).equals(token);
    }
}
