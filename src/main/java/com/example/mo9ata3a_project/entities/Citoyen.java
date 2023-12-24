package com.example.mo9ata3a_project.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Citoyen extends User{
@JsonIgnore
    @OneToMany(mappedBy = "citoyen")
    private List<Demande> demandes;
    @OneToMany(mappedBy = "id_citoyen")
    @JsonIgnore
    private List<Pdfdata> pdfs;
    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
