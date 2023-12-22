package com.example.mo9ata3a_project.services;

import com.example.mo9ata3a_project.entities.Demande_inscri;
import com.example.mo9ata3a_project.entities.User;
import com.example.mo9ata3a_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Example method to get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Example method to get a user by ID
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }



    // Example method to delete a user by ID
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User findByEmailAndPassword(String email,String password){
        return userRepository.findByEmailAndPassword(email,password);
    }

    public User saveUser(User user) {
        // You can perform any necessary logic/validation here before saving
        return userRepository.save(user);
    }


}
