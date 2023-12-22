package com.example.mo9ata3a_project.repositories;

import com.example.mo9ata3a_project.entities.Demande_inscri_refuse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Demande_inscri_refuseRepo extends JpaRepository<Demande_inscri_refuse, Long> {
}
