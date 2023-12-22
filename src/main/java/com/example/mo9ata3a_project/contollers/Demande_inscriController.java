package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.Demande_inscri;
import com.example.mo9ata3a_project.services.Demande_inscriServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demande_inscri")
@CrossOrigin("http://localhost:3000")

public class Demande_inscriController {
    @Autowired

    public Demande_inscriServices demande_inscriservice;
@PostMapping("/save")
    public ResponseEntity<Demande_inscri> savedemande(@RequestBody Demande_inscri demande_inscri)
{
    Demande_inscri saveDemande_inscri = demande_inscriservice.saveDemande_insci(demande_inscri);
    return ResponseEntity.ok(saveDemande_inscri);
}

    @GetMapping("/getall")
    public ResponseEntity<List<Demande_inscri>> getAllDemandeInscri() {
        List<Demande_inscri> allDemandes = demande_inscriservice.getAllDemande_inscri();
        return ResponseEntity.ok(allDemandes);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Demande_inscri> getDemandeInscriById(@PathVariable Long id) {
        Optional<Demande_inscri> demande_inscri = demande_inscriservice.getDemande_inscriById(id);
        return demande_inscri.map(d -> new ResponseEntity<>(d, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteDemandeInscriptionById(@PathVariable Long id) {
            demande_inscriservice.deleteDemande_inscriById(id);
            return new ResponseEntity<>("La demande d'inscription a été supprimée avec succès", HttpStatus.OK);

    }
    @GetMapping("/count")
    public ResponseEntity<Long> countdemande_inscri() {
        long count = demande_inscriservice.countCdemande_inscri();
        return ResponseEntity.ok(count);
    }
}
