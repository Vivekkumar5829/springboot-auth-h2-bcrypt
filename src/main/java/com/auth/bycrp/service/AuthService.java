package com.auth.bycrp.service;

import com.auth.bycrp.dto.LoginRequest;
import com.auth.bycrp.dto.UserRegistrationRequest;
import com.auth.bycrp.model.User;
import com.auth.bycrp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUser(UserRegistrationRequest registrationRequest){
        String encodepassword = passwordEncoder.encode(registrationRequest.getPassword());
        User user = new User(registrationRequest.getUsername(),
                encodepassword,
                registrationRequest.getEmail());
        userRepository.save(user);
        System.out.println("User registered: " + registrationRequest.getUsername());

    }


    public boolean authenticateUser(LoginRequest loginRequest) {
        return userRepository.findByUsername(loginRequest.getUsername())
                .map(user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) // ✅ match encoded
                .orElse(false);
    }
}
