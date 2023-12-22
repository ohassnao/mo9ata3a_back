package com.example.mo9ata3a_project.services;

import com.example.mo9ata3a_project.entities.Demande_inscri;
import com.example.mo9ata3a_project.entities.Demande_inscri_accepte;
import com.example.mo9ata3a_project.repositories.Demande_inscri_accepteRepo;
import com.example.mo9ata3a_project.repositories.Demande_inscri_refuseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Demande_inscri_accepteServices {
    final private Demande_inscri_accepteRepo demande_inscri_accepteRepo;
    @Autowired
    public Demande_inscri_accepteServices(Demande_inscri_accepteRepo demande_inscri_accepteRepositry) {
        this.demande_inscri_accepteRepo = demande_inscri_accepteRepositry;
    }

    public Demande_inscri_accepte saveDemande_insci_accepte(Demande_inscri_accepte demande_inscri_accepte){
        return demande_inscri_accepteRepo.save(demande_inscri_accepte);
    }
}
