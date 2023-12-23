package com.example.mo9ata3a_project.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Citoyen extends User{

    @OneToMany(mappedBy = "citoyen")
    private List<Demande> demandes;
    @OneToMany(mappedBy = "id_citoyen")
    @JsonBackReference
    private List<Pdfdata> pdfs;
    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
