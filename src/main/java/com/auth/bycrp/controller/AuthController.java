package com.auth.bycrp.controller;

import com.auth.bycrp.dto.LoginRequest;
import com.auth.bycrp.dto.UserRegistrationRequest;
import com.auth.bycrp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest registrationRequest){
        authService.registerUser(registrationRequest);
        return  new ResponseEntity<>("User registered " , HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        boolean isAuthentication = authService.authenticateUser(loginRequest);
        if(isAuthentication) {
            return new ResponseEntity<>("User logged in successfully ", HttpStatus.OK);
        }else {
           return  new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }


}
