package com.sample.pdf;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * PDF Merge
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {




    }

    public static List<InputStream> files() throws FileNotFoundException {
        List<InputStream> files = new ArrayList<>();

        FileInputStream file1 = new FileInputStream("samplepdf/1.pdf");
        FileInputStream file2 = new FileInputStream("samplepdf/2.pdf");
        FileInputStream file3 = new FileInputStream("samplepdf/3.pdf");
        FileInputStream file4 = new FileInputStream("samplepdf/4.pdf");

        files.add(file1);
        files.add(file2);
        files.add(file3);
        files.add(file4);

        return files;
    }
}
