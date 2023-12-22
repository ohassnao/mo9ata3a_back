package com.example.mo9ata3a_project.entities;

import jakarta.persistence.Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Admin_commune extends User{

    private String commune;
    @OneToMany(mappedBy = "admin_commune")
    private List <Fonctionnaire> fonctionnaires;
    @ManyToOne
    private Admin_logiciel admin_logiciel;


}