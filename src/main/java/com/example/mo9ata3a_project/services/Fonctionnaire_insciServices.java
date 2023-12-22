package com.example.mo9ata3a_project.services;
import com.example.mo9ata3a_project.entities.Citoyen;
import com.example.mo9ata3a_project.entities.Fonctionnaire_inscri;
import com.example.mo9ata3a_project.repositories.Fonctionnaire_inscriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Fonctionnaire_insciServices {
    private final Fonctionnaire_inscriRepo fonc_inscri_repo;
    @Autowired
    public Fonctionnaire_insciServices(Fonctionnaire_inscriRepo fonc_inscri_repo){
        this.fonc_inscri_repo = fonc_inscri_repo;
    }
    public long countFonc_inscri() {
        return fonc_inscri_repo.count();
    }
    public Fonctionnaire_inscri saveFonc_inscri(Fonctionnaire_inscri fonc_inscri){
        return fonc_inscri_repo.save(fonc_inscri);
    }

}
