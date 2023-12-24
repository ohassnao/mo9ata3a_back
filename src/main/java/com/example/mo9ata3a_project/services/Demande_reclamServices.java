package com.example.mo9ata3a_project.services;

import com.example.mo9ata3a_project.entities.Demande_reclam;
import com.example.mo9ata3a_project.repositories.Demande_reclamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Demande_reclamServices {
    private final Demande_reclamRepo demande_reclamrepo;
    @Autowired
    public Demande_reclamServices(Demande_reclamRepo demande_reclamrepo){
        this.demande_reclamrepo = demande_reclamrepo;
    }
    public List<Demande_reclam> getAllDemandesReclam() {
        return demande_reclamrepo.findAll();
    }
    public Optional<Demande_reclam> getDemandeReclamById(Long id) {
        return demande_reclamrepo.findById(id);
    }
    public Demande_reclam saveDemandeReclam(Demande_reclam demandeReclam) {
        return demande_reclamrepo.save(demandeReclam);
    }
    public void deleteDemandeReclamById(Long id) {
        demande_reclamrepo.deleteById(id);
    }
}
