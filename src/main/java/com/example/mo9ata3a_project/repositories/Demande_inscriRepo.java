package com.example.mo9ata3a_project.repositories;

import com.example.mo9ata3a_project.entities.Demande_inscri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Demande_inscriRepo extends JpaRepository <Demande_inscri,Long>{

}
