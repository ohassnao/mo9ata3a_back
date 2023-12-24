package com.example.mo9ata3a_project.repositories;

import com.example.mo9ata3a_project.entities.Demande_reclam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Demande_reclamRepo extends JpaRepository <Demande_reclam,Long>{
}
