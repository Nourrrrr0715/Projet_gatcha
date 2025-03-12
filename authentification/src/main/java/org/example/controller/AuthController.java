package org.example.controller;

import org.example.dto.AuthResponse;
import org.example.model.*;
import org.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request) {
        String token = authService.authenticate(request.getUsername(), request.getPassword());
        if (token != null) {
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).body(new AuthResponse("Invalid credentials"));
    }
}
