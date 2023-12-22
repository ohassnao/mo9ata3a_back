package com.example.mo9ata3a_project.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Document_legal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_doc_legal;

    private boolean confidentiel;

    private Date date;

    @OneToOne(mappedBy = "doc_legal")
    private Demande_legal demande_legal;

    @OneToOne (mappedBy = "doc_legal")
    private Fonctionnaire_legal fonc_legal;

    public Long getId_doc_legal() {
        return Id_doc_legal;
    }

    public void setId_doc_legal(Long id_doc_legal) {
        Id_doc_legal = id_doc_legal;
    }

    public boolean isConfidentiel() {
        return confidentiel;
    }

    public void setConfidentiel(boolean confidentiel) {
        this.confidentiel = confidentiel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Demande_legal getDemande_legal() {
        return demande_legal;
    }

    public void setDemande_legal(Demande_legal demande_legal) {
        this.demande_legal = demande_legal;
    }

    public Fonctionnaire_legal getFonc_legal() {
        return fonc_legal;
    }

    public void setFonc_legal(Fonctionnaire_legal fonc_legal) {
        this.fonc_legal = fonc_legal;
    }




}

