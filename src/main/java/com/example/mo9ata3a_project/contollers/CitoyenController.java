package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.Citoyen;
import com.example.mo9ata3a_project.entities.Demande_inscri;
import com.example.mo9ata3a_project.entities.User;
import com.example.mo9ata3a_project.services.CitoyenServices;
import com.example.mo9ata3a_project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/citoyen")
@CrossOrigin("http://localhost:3000")

public class CitoyenController {

    @Autowired
    private CitoyenServices citoyenservices;
    @Autowired
    private UserServices userServices;
    @PostMapping("/save")
    public ResponseEntity<Citoyen> saveCityoen(@RequestBody Citoyen citoyen) {
        Citoyen savedCitoyen = citoyenservices.saveCitoyen(citoyen);
        return ResponseEntity.ok(savedCitoyen);
    }
    @GetMapping("/count")
    public ResponseEntity<Long> countCitoyens() {
        long count = citoyenservices.countCitoyens();
        return ResponseEntity.ok(count);
    }
    @GetMapping("/countByQuartier")
    public ResponseEntity<List<Map<String, Object>>> getCitoyenCountByQuartier() {
        List<Map<String, Object>> counts = citoyenservices.getCitoyenCountByQuartier();
        return ResponseEntity.ok(counts);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Citoyen>> getAllCitoyen() {
        List<Citoyen> allCitoyen = citoyenservices.getAllCitoyen();
        return ResponseEntity.ok(allCitoyen);
    }
    @PostMapping("/checkCitoyen")
    public ResponseEntity<?> findUserByEmailAndPassword(@RequestBody Map<String,String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Citoyen citoyen = (Citoyen) userServices.findByEmailAndPassword(email, password);

        if (citoyen != null) {
            // User found, send a success response with the user object
            return new ResponseEntity<>(citoyen, HttpStatus.OK);
        } else {
            // User not found, send an error response with a custom error message
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
