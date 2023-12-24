package com.example.mo9ata3a_project.repositories;

import com.example.mo9ata3a_project.entities.Pdfdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PdfRepo extends JpaRepository<Pdfdata,Long> {

    Optional<Pdfdata> findByName(String fileName);
    @Query("SELECT pdf FROM Pdfdata pdf WHERE pdf.id_citoyen.id_user = :idCitoyen")
    List<Pdfdata> findById_citoyen(Long idCitoyen);
}