package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.Demande_inscri;
import com.example.mo9ata3a_project.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")

public class AcceptanceController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/accept-user")
    public ResponseEntity<String> acceptUser(@RequestBody Demande_inscri userDetails) {
        // Logic to accept the user

        // Send a detailed acceptance email to the user
        String recipientEmail = userDetails.getEmail();
        String subject = "Your Registration in MO9ATA3A.ma is Approved";
        String message = "Dear " + userDetails.getPrenom() + " " + userDetails.getNom() + ",\n" +
                "Congratulations! Your account is approved on MO9ATA3A.ma.\n" +
                "You are now part of our community.\n" +
                "Your login details:\n" +
                "\tEmail: " + userDetails.getEmail() + "\n" +
                "\tPassword: " + userDetails.getPassword() + "\n" +
                "\tConfidentiel Code: " + userDetails.getCode_conf() + "\n" +
                "Thank you for joining us!\n" +
                "Best regards,\n" +
                "The MO9ATA3A.ma Team";

        emailService.sendEmail(recipientEmail, subject, message);

        return ResponseEntity.ok("User accepted and a detailed email sent.");
    }

    @PostMapping("/refuse-user")
    public ResponseEntity<String> refuseUser(@RequestBody Demande_inscri userDetails) {
        // Logic to refuse the user

        // Send a detailed email to the refused user
        String recipientEmail = userDetails.getEmail();
        String subject = "Your Registration in MO9ATA3A.ma has been refused";
        String message = "Dear " + userDetails.getPrenom() + " " + userDetails.getNom() + ",\n" +
                "We regret to inform you that your account registration has been refused.\n" +
                "Unfortunately, your application did not meet our current requirements. " +
                "Please feel free to contact us for further information.\n" +
                "Thank you for your interest in our platform.";

        emailService.sendEmail(recipientEmail, subject, message);

        return ResponseEntity.ok("User refused and detailed email sent.");
    }


}
