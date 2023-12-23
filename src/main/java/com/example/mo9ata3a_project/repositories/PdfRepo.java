package com.example.mo9ata3a_project.repositories;

import com.example.mo9ata3a_project.entities.Pdfdata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PdfRepo extends JpaRepository<Pdfdata,Long> {

    Optional<Pdfdata> findByName(String fileName);
}