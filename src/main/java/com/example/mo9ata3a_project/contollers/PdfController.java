package com.example.mo9ata3a_project.contollers;

import com.example.mo9ata3a_project.entities.Citoyen;
import com.example.mo9ata3a_project.entities.Pdfdata;
import com.example.mo9ata3a_project.services.CitoyenServices;
import com.example.mo9ata3a_project.services.PdfdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pdf")
@CrossOrigin("http://localhost:3000")

public class PdfController {
    @Autowired
    private PdfdataService service;
    @Autowired
    private CitoyenServices citoyenService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<Pdfdata>> getAllPdf() {
        List<Pdfdata> pdfList = service.getAllPdf();
        return ResponseEntity.ok(pdfList);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPdf(
            @RequestParam("pdfh") MultipartFile file,
            @RequestParam("id_citoyen") Long idCitoyen,
            @RequestParam("documentType") String documentType,
            @RequestParam("reasons") String reasons) {
        try {
            // Validate if the Citoyen exists
            Citoyen citoyen = citoyenService.getCitoyenById(idCitoyen);
            if (citoyen != null) {
                String uploadPdf = service.uploadPdf(file, idCitoyen, documentType, reasons);
                return ResponseEntity.status(HttpStatus.OK).body(uploadPdf);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Citoyen with ID " + idCitoyen + " not found.");
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading PDF: " + e.getMessage());
        }
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable String fileName) {
        byte[] pdfData = service.downloadPdf(fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData(fileName, fileName);
        headers.setCacheControl(CacheControl.noCache());

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }

    @GetMapping("/downloadWithImage/{fileName}")
    public ResponseEntity<byte[]> downloadPdfWithImage(@PathVariable String fileName) {
        try {
            byte[] pdfDataWithImage = service.downloadAndInsertImage(fileName);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData(fileName, fileName);
            headers.setCacheControl(CacheControl.noCache());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfDataWithImage);
        } catch (IOException e) {
            // Log the exception or handle it accordingly
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/pdf/count")
    public ResponseEntity<Long> countPdf() {
        long count = service.countPdf();
        return ResponseEntity.ok(count);
    }

}