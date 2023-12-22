package com.example.mo9ata3a_project.repositories;

import com.example.mo9ata3a_project.entities.Demande_inscri_accepte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Demande_inscri_accepteRepo extends JpaRepository<Demande_inscri_accepte, Long> {
}
