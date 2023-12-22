package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.Citoyen;
import com.example.mo9ata3a_project.entities.Fonctionnaire_inscri;
import com.example.mo9ata3a_project.services.Fonctionnaire_insciServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/fonc_inscri" +
        "")
@CrossOrigin("http://localhost:3000")
public class Fonctionnaire_inscriController {
    @Autowired
    private Fonctionnaire_insciServices fonc_inscri_serv;
    @GetMapping("/count")
    public ResponseEntity<Long> countFonc_inscri() {
        long count = fonc_inscri_serv.countFonc_inscri();
        return ResponseEntity.ok(count);
    }
    @PostMapping("/save")
    public ResponseEntity<Fonctionnaire_inscri> saveFonc_inscri(@RequestBody Fonctionnaire_inscri fonc_inscri) {
        Fonctionnaire_inscri savedFonc_inscri = fonc_inscri_serv.saveFonc_inscri(fonc_inscri);
        return ResponseEntity.ok(savedFonc_inscri);
    }
}
