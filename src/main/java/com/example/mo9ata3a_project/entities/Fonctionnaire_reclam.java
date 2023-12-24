package com.example.mo9ata3a_project.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
public class Fonctionnaire_reclam extends Fonctionnaire{
    @OneToMany(mappedBy="fonc_reclam")
    @JsonBackReference
    private List<Demande_reclam> demande_reclam;

    public List<Demande_reclam> getDemande_reclam() {
        return demande_reclam;
    }

    public void setDemande_reclam(List<Demande_reclam> demande_reclam) {
        this.demande_reclam = demande_reclam;
    }
}

