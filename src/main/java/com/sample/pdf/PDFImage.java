package com.sample.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.logging.Logger;

public class PDFImage {

    Logger logger = Logger.getLogger(this.getClass().getName());

    public void addImage(String pdfpath, String imagePath, String output){

        long startTime = Instant.now().toEpochMilli();

        File file = new File(pdfpath);
        PDDocument doc = null;
        try {
            logger.info("Add image to pdf started");
            doc = PDDocument.load(file);
            // Choose IMAGE File
            PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);
            doc.addPage(new PDPage());
            PDPage page = doc.getPage(doc.getNumberOfPages()-1);
            PDPageContentStream contentStream = new PDPageContentStream(doc,page);
            // Set Position of image on PDF
            contentStream.drawImage(pdImage, 70, 250);
            contentStream.close();
            doc.save(output);
            doc.close();
            logger.info("Add image to pdf ended");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = Instant.now().toEpochMilli();

        long timeElapsed = endTime - startTime;

        logger.info("Execution time in milliseconds : " + timeElapsed);

    }
}
