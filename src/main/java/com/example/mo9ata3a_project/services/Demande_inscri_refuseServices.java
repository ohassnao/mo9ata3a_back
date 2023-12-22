package com.example.mo9ata3a_project.services;

import com.example.mo9ata3a_project.entities.Demande_inscri_accepte;
import com.example.mo9ata3a_project.entities.Demande_inscri_refuse;
import com.example.mo9ata3a_project.repositories.Demande_inscriRepo;
import com.example.mo9ata3a_project.repositories.Demande_inscri_refuseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Demande_inscri_refuseServices {
    final private Demande_inscri_refuseRepo demande_inscri_refuseRepo;
@Autowired
    public Demande_inscri_refuseServices(Demande_inscri_refuseRepo demande_inscri_refuseRepositry) {
        this.demande_inscri_refuseRepo = demande_inscri_refuseRepositry;
    }

    public Demande_inscri_refuse saveDemande_insci_refuse(Demande_inscri_refuse demande_inscri_refuse){
        return demande_inscri_refuseRepo.save(demande_inscri_refuse);
    }
}
