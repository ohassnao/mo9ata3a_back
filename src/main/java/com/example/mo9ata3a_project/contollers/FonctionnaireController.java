package com.example.mo9ata3a_project.contollers;


import com.example.mo9ata3a_project.entities.Fonctionnaire;
import com.example.mo9ata3a_project.entities.User;
import com.example.mo9ata3a_project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/fonctionnaire")
@CrossOrigin("http://localhost:3000")
public class FonctionnaireController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/checkFonc")
    public ResponseEntity<?> findUserByEmailAndPassword(@RequestBody Map<String,String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Fonctionnaire fonctionnaire = (Fonctionnaire) userServices.findByEmailAndPassword(email, password);

        if (fonctionnaire != null) {
            // User found, send a success response with the user object
            return new ResponseEntity<>(fonctionnaire, HttpStatus.OK);
        } else {
            // User not found, send an error response with a custom error message
            return new ResponseEntity<>("Fonctionnaire not found", HttpStatus.NOT_FOUND);
        }
    }

}