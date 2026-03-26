package com.Zineb.gestionfacturation.service;

import com.Zineb.gestionfacturation.dto.AuthResponse;
import com.Zineb.gestionfacturation.dto.LoginRequest;
import com.Zineb.gestionfacturation.dto.RegisterRequest;
import com.Zineb.gestionfacturation.entity.User;
import com.Zineb.gestionfacturation.repository.UserRepository;
import com.Zineb.gestionfacturation.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setNom(request.getNom());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(User.Role.USER);
        userRepository.save(user);
        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email introuvable"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }
        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}