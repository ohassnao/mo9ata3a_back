package com.example.mo9ata3a_project.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Fonctionnaire_legal extends Fonctionnaire{
    @OneToOne
    private Document_legal doc_legal;
    @OneToMany(mappedBy = "fonc_legal")
    private List<Demande_legal> demandes_legal;
    @OneToMany(mappedBy = "id_foncLegal")
    @JsonBackReference
    private List<Pdfdata> pdflegal;
}
