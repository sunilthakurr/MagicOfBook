package com.example.BookManagement.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.BookManagement.model.User;
import com.example.BookManagement.model.UserRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginRequest) {
        User user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        
        if (user != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(409).body("Username already exists");
        }
        userRepository.save(user);
        return ResponseEntity.ok("Registration successful");
    }
}