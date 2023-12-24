package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.Demande_reclam;
import com.example.mo9ata3a_project.services.Demande_reclamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demande-reclam")
@CrossOrigin("http://localhost:3000")

public class Demande_reclamController {

    private final Demande_reclamServices demandeReclamServices;

    @Autowired
    public Demande_reclamController(Demande_reclamServices demandeReclamServices) {
        this.demandeReclamServices = demandeReclamServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Demande_reclam>> getAllDemandesReclam() {
        List<Demande_reclam> demandesReclam = demandeReclamServices.getAllDemandesReclam();
        return ResponseEntity.ok(demandesReclam);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demande_reclam> getDemandeReclamById(@PathVariable Long id) {
        Optional<Demande_reclam> demandeReclam = demandeReclamServices.getDemandeReclamById(id);
        return demandeReclam.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Demande_reclam> createDemandeReclam(@RequestBody Demande_reclam demandeReclam) {
        Demande_reclam savedDemandeReclam = demandeReclamServices.saveDemandeReclam(demandeReclam);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDemandeReclam);
    }
}