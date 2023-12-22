package com.example.mo9ata3a_project.entities;


import jakarta.persistence.*;
@Entity
public class Demande_legal  extends Demande{
    private String Raison;
    @OneToOne
    private Document_legal doc_legal;
    @ManyToOne
    private Fonctionnaire_legal fonc_legal;
    public String getRaison() {
        return Raison;
    }
    public void setRaison(String raison) {
        Raison = raison;
    }
    public Document_legal getDoc_legal() {
        return doc_legal;
    }
    public void setDoc_legal(Document_legal doc_legal) {
        this.doc_legal = doc_legal;
    }
    public Fonctionnaire_legal getFonc_legal() {
        return fonc_legal;
    }
    public void setFonc_legal(Fonctionnaire_legal fonc_legal) {
        this.fonc_legal = fonc_legal;
    }
}
