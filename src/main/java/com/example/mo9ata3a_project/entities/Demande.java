package com.example.mo9ata3a_project.entities;



import java.util.Date;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Demande;

    private String type_demande;

    @ManyToOne
    private Fonctionnaire fonctionnaire;

    @ManyToOne
    private Citoyen citoyen;



    public Fonctionnaire getFonctionnaire() {
        return fonctionnaire;
    }
    public void setFonctionnaire(Fonctionnaire fonctionnaire) {
        this.fonctionnaire = fonctionnaire;
    }
    public Citoyen getCitoyen() {
        return citoyen;
    }
    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }


    public Long getId_Demande() {
        return Id_Demande;
    }
    public void setId_Demande(Long id_Demande) {
        Id_Demande = id_Demande;
    }
    public String getType_demande() {
        return type_demande;
    }
    public void setType_demande(String type_demande) {
        this.type_demande = type_demande;
    }


}