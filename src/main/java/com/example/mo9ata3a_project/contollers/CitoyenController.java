package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.Citoyen;
import com.example.mo9ata3a_project.entities.Demande_inscri;
import com.example.mo9ata3a_project.entities.User;
import com.example.mo9ata3a_project.services.CitoyenServices;
import org.springframework.beans.factory.annotation.Autowired;
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
}
