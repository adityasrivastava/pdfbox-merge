package com.sample.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class PDFImage {

    public void addImage(String pdfpath, String imagePath, String output){
        File file = new File(pdfpath);
        PDDocument doc = null;
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
