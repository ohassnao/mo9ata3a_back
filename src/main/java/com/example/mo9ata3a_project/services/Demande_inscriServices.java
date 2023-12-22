package com.example.mo9ata3a_project.services;

import com.example.mo9ata3a_project.entities.Demande_inscri;
import com.example.mo9ata3a_project.repositories.Demande_inscriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Demande_inscriServices {

    private Demande_inscriRepo demande_inscrirepo;

    @Autowired
    public Demande_inscriServices(Demande_inscriRepo demande_inscriRepository) {
        this.demande_inscrirepo = demande_inscriRepository;
    }

    public Demande_inscri saveDemande_insci(Demande_inscri demande_inscri){
        return demande_inscrirepo.save(demande_inscri);
    }

    public List<Demande_inscri> getAllDemande_inscri(){
        return demande_inscrirepo.findAll();
    }

        public Optional<Demande_inscri> getDemande_inscriById(Long id){
            return demande_inscrirepo.findById(id);
        }

    public Demande_inscri updateDemande_inscri(Demande_inscri demande_inscri){
        // Check if the demande_inscri exists in the repository
        if(demande_inscrirepo.existsById(demande_inscri.getId_Demande())){
            return demande_inscrirepo.save(demande_inscri);
        }
        return null; // Or throw an exception indicating the resource wasn't found
    }

    public boolean deleteDemande_inscriById(Long id){
        // Check if the demande_inscri exists in the repository
        if(demande_inscrirepo.existsById(id)){
            demande_inscrirepo.deleteById(id);
            return true;
        }
        return false; // Or throw an exception indicating the resource wasn't found
    }

    public long countCdemande_inscri() {
        return demande_inscrirepo.count();
    }
}
