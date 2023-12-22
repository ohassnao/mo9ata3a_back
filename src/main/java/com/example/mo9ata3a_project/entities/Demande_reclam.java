package com.example.mo9ata3a_project.entities;

import jakarta.persistence.*;

@Entity
public class Demande_reclam  extends Demande{
    @ManyToOne
    private Fonctionnaire_reclam fonc_reclam;

    public Fonctionnaire_reclam getFonc_reclam() {
        return fonc_reclam;
    }

    public void setFonc_reclam(Fonctionnaire_reclam fonc_reclam) {
        this.fonc_reclam = fonc_reclam;
    }

}
