package com.example.mo9ata3a_project.entities;

import java.util.List;

import jakarta.persistence.*;
@Entity
public class Fonctionnaire_fourdoc extends Fonctionnaire{
    @OneToOne
    private Document_four doc_four;

    @OneToMany(mappedBy = "fonc_fourdoc")
    private List<Demande_doc> demandes_doc;

    public Document_four getDoc_four() {
        return doc_four;
    }

    public void setDoc_four(Document_four doc_four) {
        this.doc_four = doc_four;
    }
}
