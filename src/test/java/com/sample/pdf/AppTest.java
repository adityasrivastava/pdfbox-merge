package com.sample.pdf;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    List<InputStream> files;

    @Before
    public void before() throws FileNotFoundException {
        files = new ArrayList<>();
        FileInputStream file1 = new FileInputStream("samplepdf/1.pdf");
        FileInputStream file2 = new FileInputStream("samplepdf/2.pdf");
        FileInputStream file3 = new FileInputStream("samplepdf/3.pdf");
        FileInputStream file4 = new FileInputStream("samplepdf/4.pdf");
        files.add(file1);
        files.add(file2);
        files.add(file3);
        files.add(file4);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        PDFMerge merge = new PDFMerge();
        merge.merge(files, "merge1.pdf");
    }
}
