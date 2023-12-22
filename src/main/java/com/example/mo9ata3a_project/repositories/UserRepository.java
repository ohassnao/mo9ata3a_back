package com.example.mo9ata3a_project.repositories;

import com.example.mo9ata3a_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmailAndPassword(String Email, String Password);
}
