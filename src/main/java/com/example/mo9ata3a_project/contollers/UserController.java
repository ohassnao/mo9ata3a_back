package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.User;
import com.example.mo9ata3a_project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")

public class    UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/checkUser")
    public ResponseEntity<?> findUserByEmailAndPassword(@RequestBody Map<String,String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        User user = userServices.findByEmailAndPassword(email, password);

        if (user != null) {
            // User found, send a success response with the user object
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            // User not found, send an error response with a custom error message
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userServices.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }



}

