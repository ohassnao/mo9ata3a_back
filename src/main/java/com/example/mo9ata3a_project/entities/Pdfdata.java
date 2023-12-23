package com.example.mo9ata3a_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PdfData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pdfdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Lob
    @Column(name = "pdfdata",columnDefinition = "LONGBLOB")
    private byte[] pdfdata;

    @Lob
    @Column(name = "pdfdataegal",columnDefinition = "LONGBLOB")
    private byte[] pdfdataegal;

    @ManyToOne
    private Citoyen id_citoyen;

    private String reasons;
    private String documentType;
    @ManyToOne
    private Fonctionnaire_legal id_foncLegal;
}