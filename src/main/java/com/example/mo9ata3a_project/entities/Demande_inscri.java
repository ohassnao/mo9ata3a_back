package com.example.mo9ata3a_project.entities;

import jakarta.persistence.*;

import java.security.SecureRandom;
import java.util.Date;

@Entity
public class Demande_inscri extends Demande{


    @ManyToOne
    private Fonctionnaire_inscri fonc_inscri;
    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private String username;

    private String email;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    public String getCode_conf() {
        return code_conf;
    }

    public void setCode_conf(String code_conf) {
        this.code_conf = code_conf;
    }

    private String code_conf;
    private String generateRandomCode() {
        // Génère un code confidentiel aléatoire
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }
    @PrePersist
    protected void onCreate() {
        date = new Date(); // Cette ligne initialise automatiquement la date lors de la création
        code_conf = generateRandomCode();

    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Fonctionnaire_inscri getFonc_inscri() {
        return fonc_inscri;
    }

    public void setFonc_inscri(Fonctionnaire_inscri fonc_inscri) {
        this.fonc_inscri = fonc_inscri;
    }

}
