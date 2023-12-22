package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.Demande_inscri_refuse;
import com.example.mo9ata3a_project.services.Demande_inscri_refuseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/demande_inscri_refuse")
@CrossOrigin("http://localhost:3000")
public class Demande_inscri_refuseController {
    @Autowired
    public Demande_inscri_refuseServices demande_inscri_refuseservice;
    @PostMapping("/save")
    public ResponseEntity<Demande_inscri_refuse> savedemande_refuse(@RequestBody Demande_inscri_refuse demande_inscri_refuse)
    {
        Demande_inscri_refuse saveDemande_inscri_refuse = demande_inscri_refuseservice.saveDemande_insci_refuse(demande_inscri_refuse);
        return ResponseEntity.ok(saveDemande_inscri_refuse);
    }
}
