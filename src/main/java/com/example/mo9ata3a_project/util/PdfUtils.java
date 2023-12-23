package com.example.mo9ata3a_project.util;
import com.example.mo9ata3a_project.entities.Pdfdata;
import com.example.mo9ata3a_project.repositories.PdfRepo;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
@Component
public class PdfUtils {
    public static byte[] compressImage(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }



    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }

    /*public static byte[] insertImageIntoPdf(byte[] pdfData, String imageName, PdfRepo repository) throws IOException {
        try (PDDocument document = PDDocument.load(pdfData)) {
            PDPage page = document.getPage(0);

            byte[] imageData = getImageDataByName(imageName, repository);
            System.out.println("Image Data Length: " + imageData.length);

            // Check if the image data is available
            if (imageData == null || imageData.length == 0) {
                System.err.println("Image data is null or empty. Cannot insert image.");
                return pdfData;
            }

            // Specify the image format explicitly (e.g., "png" or "jpg")
            String imageFormat = "JPEG"; // Change this based on your image format

            try {
                // Create a PDImageXObject from the image data
                        PDImageXObject imageXObject = PDImageXObject.createFromByteArray(document, imageData, imageFormat);

                // Log the length of the image data
                System.out.println("Image Data Length: " + imageData.length);

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true)) {
                    contentStream.drawImage(imageXObject, 100, 100);
                }
            } catch (IOException e) {
                // Log or handle the exception, e.g., image file format issue
                e.printStackTrace();
                System.err.println("Error processing image: " + e.getMessage());
                return pdfData;
            }

            return saveDocumentToByteArray(document);
        }
    }*/
    public static byte[] insertImageIntoPdf(byte[] pdfData, String imageName, PdfRepo repository) throws IOException {
        try (PDDocument document = PDDocument.load(pdfData)) {
            PDPage page = document.getPage(0);

            byte[] imageData = getImageDataByName(imageName, repository);

            // Check if the image data is available
            if (imageData == null || imageData.length == 0) {
                System.err.println("Image data is null or empty. Cannot insert image.");
                return pdfData;
            }

            // Specify the image format explicitly (e.g., "png" or "jpg")
            String imageFormat = "jpeg"; // Change this based on your image format

            try {
                // Create a PDImageXObject from the image data
                PDImageXObject imageXObject = PDImageXObject.createFromByteArray(document, imageData, imageFormat);

                // Log the length of the image data
                System.out.println("Image Data Length: " + imageData.length);

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true)) {
                    contentStream.drawImage(imageXObject, 100, 100);
                }
            } catch (IOException e) {
                // Log or handle the exception, e.g., image file format issue
                e.printStackTrace();
                System.err.println("Error processing image: " + e.getMessage());
                System.err.println("Image Data: " + Arrays.toString(imageData));
                return pdfData;
            }

            return saveDocumentToByteArray(document);
        }
    }





    private static byte[] getImageDataByName(String imageName, PdfRepo repository) {
        Optional<Pdfdata> pdfDataOptional = repository.findByName(imageName);

        if (pdfDataOptional.isPresent()) {
            byte[] imageData = pdfDataOptional.get().getPdfdata();
            System.out.println("Retrieved Image Data: " + Arrays.toString(imageData));
            return imageData;
        } else {
            // Log or throw an exception to handle the case when the image is not found
            System.err.println("Image not found with name: " + imageName);
            return new byte[0];
        }
    }



    private static byte[] saveDocumentToByteArray(PDDocument document) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();
        return baos.toByteArray();
    }
}