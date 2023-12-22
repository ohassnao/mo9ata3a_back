package com.example.mo9ata3a_project.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Citoyen extends User{

    @OneToMany(mappedBy = "citoyen")
    private List<Demande> demandes;

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
