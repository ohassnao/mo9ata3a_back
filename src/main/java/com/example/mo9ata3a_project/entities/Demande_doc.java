package com.example.mo9ata3a_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Demande_doc extends Demande{
    @OneToOne
    private Document_four doc_four;

    @ManyToOne
    private Fonctionnaire_fourdoc fonc_fourdoc;



}
