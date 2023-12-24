package com.example.mo9ata3a_project.services;

import com.example.mo9ata3a_project.entities.Citoyen;
import com.example.mo9ata3a_project.entities.Pdfdata;
import com.example.mo9ata3a_project.repositories.PdfRepo;
import com.example.mo9ata3a_project.util.PdfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PdfdataService {

    @Autowired
    private PdfRepo repository;

    @Autowired
    private PdfUtils pdfUtils;

    @Autowired
    private CitoyenServices citoyenService;
    public String uploadPdf(MultipartFile file, Long idCitoyen, String documentType, String reasons) throws IOException {
        try {
            // Fetch the Citoyen entity
            Citoyen citoyen = citoyenService.getCitoyenById(idCitoyen);

            // Save the Pdfdata entity
            Pdfdata pdfData = repository.save(
                    Pdfdata.builder()
                            .name(file.getOriginalFilename())
                            .type(file.getContentType())
                            .pdfdata(PdfUtils.compressImage(file.getBytes()))
                            .id_citoyen(citoyen) // Set the Citoyen entity
                            .documentType(documentType) // Set documentType
                            .reasons(reasons) // Set reasons
                            .build()
            );

            if (pdfData != null) {
                return "File uploaded successfully: " + file.getOriginalFilename();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public byte[] downloadPdf(String fileName){
        Optional<Pdfdata> dbPdfData=repository.findByName(fileName);
        byte[] pdfs=PdfUtils.decompressImage(dbPdfData.get().getPdfdata());
        return pdfs;
    }

    public List<Pdfdata> getAllPdf() {
        return repository.findAll();
    }

    public byte[] downloadAndInsertImage(String fileName) throws IOException {
        byte[] pdfData = downloadPdf(fileName);
        return PdfUtils.insertImageIntoPdf(pdfData, "signature.jpeg", repository);
    }
    public Long countPdf(){
        return repository.count();
    }

    public List<Pdfdata> getPdfdataByCitoyenId(Long idCitoyen) {
        return repository.findById_citoyen(idCitoyen);
    }
}