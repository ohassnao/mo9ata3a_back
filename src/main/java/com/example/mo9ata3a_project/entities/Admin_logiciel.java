package com.example.mo9ata3a_project.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Admin_logiciel extends User {
    @OneToMany(mappedBy = "admin_logiciel")
    private List<Admin_commune> admin_commune;
    @OneToMany(mappedBy = "admin_logiciel")
    private List<Fonctionnaire> fonctionnaires;
}

