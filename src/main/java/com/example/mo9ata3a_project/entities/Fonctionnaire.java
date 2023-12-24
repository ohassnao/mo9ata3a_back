package com.example.mo9ata3a_project.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Fonctionnaire extends User{
    String departement;




    @JsonIgnore
    @OneToMany(mappedBy = "fonctionnaire")
    private List <Demande> demandes;
    @ManyToOne
    private Admin_commune admin_commune;
    @ManyToOne
    private Admin_logiciel admin_logiciel;



    public Fonctionnaire() {
        super();
    }
}
