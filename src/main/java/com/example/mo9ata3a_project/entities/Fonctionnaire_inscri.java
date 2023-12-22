package com.example.mo9ata3a_project.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Fonctionnaire_inscri extends Fonctionnaire{
    @OneToMany(mappedBy = "fonc_inscri")
    private List<Demande_inscri> demandes_inscri;


    public List<Demande_inscri> getDemandes_inscri() {
        return demandes_inscri;
    }

    public void setDemandes_inscri(List<Demande_inscri> demandes_inscri) {
        this.demandes_inscri = demandes_inscri;
    }
}

