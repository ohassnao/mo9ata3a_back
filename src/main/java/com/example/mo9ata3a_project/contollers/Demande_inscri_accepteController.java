package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.Demande_inscri;
import com.example.mo9ata3a_project.entities.Demande_inscri_accepte;
import com.example.mo9ata3a_project.services.Demande_inscri_accepteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demande_inscri_accepte")
@CrossOrigin("http://localhost:3000")
public class Demande_inscri_accepteController {

    @Autowired
    public Demande_inscri_accepteServices demande_inscri_accepteservice;
    @PostMapping("/save")
    public ResponseEntity<Demande_inscri_accepte> savedemande_accpte(@RequestBody Demande_inscri_accepte demande_inscri_accepte)
    {
        Demande_inscri_accepte saveDemande_inscri_accepte = demande_inscri_accepteservice.saveDemande_insci_accepte(demande_inscri_accepte);
        return ResponseEntity.ok(saveDemande_inscri_accepte);
    }
}
