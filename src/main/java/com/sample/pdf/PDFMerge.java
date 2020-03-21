package com.sample.pdf;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.List;
import java.util.logging.Logger;

public class PDFMerge {

    Logger logger = Logger.getLogger(this.getClass().getName());

    public void merge(List<InputStream> inputStreams, String output) throws IOException {

        logger.info("Merging total pdfs : "+inputStreams.size());

        long startTime = Instant.now().toEpochMilli();

        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        mergerUtility.setDestinationFileName(output);

        mergerUtility.addSources(inputStreams);
        mergerUtility.setDocumentMergeMode(PDFMergerUtility.DocumentMergeMode.OPTIMIZE_RESOURCES_MODE);
        mergerUtility.mergeDocuments();

        long endTime = Instant.now().toEpochMilli();

        long timeElapsed = endTime - startTime;

        logger.info("Execution time in milliseconds : " + timeElapsed);
    }
}
