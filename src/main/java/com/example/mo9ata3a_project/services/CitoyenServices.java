package com.example.mo9ata3a_project.services;

import com.example.mo9ata3a_project.entities.Citoyen;
import com.example.mo9ata3a_project.entities.Demande_inscri;
import com.example.mo9ata3a_project.repositories.CitoyenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CitoyenServices {
    private final CitoyenRepo citoyenrepo;

    @Autowired
    public CitoyenServices(CitoyenRepo citoyenrepo){
        this.citoyenrepo = citoyenrepo;
    }

    public Citoyen saveCitoyen(Citoyen citoyen){
        return citoyenrepo.save(citoyen);
    }
    public List<Citoyen> getAllCitoyen(){
        return citoyenrepo.findAll();
    }

    public long countCitoyens() {
        return citoyenrepo.count();
    }

    public List<Map<String, Object>> getCitoyenCountByQuartier() {
        return citoyenrepo.getCitoyenCountByQuartier();
    }
    }



