package com.example.mo9ata3a_project.entities;

import java.util.Date;

import jakarta.persistence.*;
@Entity
public class Document_four {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_doc_four;

    private boolean confidentiel;

    public Long getId_doc_four() {
        return Id_doc_four;
    }

    public void setId_doc_four(Long id_doc_four) {
        Id_doc_four = id_doc_four;
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

    public Demande_doc getDemande_four() {
        return demande_four;
    }

    public void setDemande_four(Demande_doc demande_four) {
        this.demande_four = demande_four;
    }

    public Fonctionnaire_fourdoc getFonc_four() {
        return fonc_four;
    }

    public void setFonc_four(Fonctionnaire_fourdoc fonc_four) {
        this.fonc_four = fonc_four;
    }

    private Date date;

    @OneToOne(mappedBy = "doc_four")
    private Demande_doc demande_four;

    @OneToOne (mappedBy = "doc_four")
    private Fonctionnaire_fourdoc fonc_four;


}
