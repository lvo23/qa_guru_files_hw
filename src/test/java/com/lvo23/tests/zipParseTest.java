package com.lvo23.tests;

import static com.lvo23.utils.CreateFilesUtils.createTestCSVFile;
import static com.lvo23.utils.CreateFilesUtils.createTestPDFFile;
import static com.lvo23.utils.CreateFilesUtils.createTestXLSFile;
import static com.lvo23.utils.ZipUtils.createZipMultiFiles;
import static com.lvo23.utils.ZipUtils.unzip;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

import com.codeborne.pdftest.PDF;
import com.lvo23.BaseTest;

/**
 * @author Vlad Litvinov
 */
public class zipParseTest extends BaseTest {

    ClassLoader cl = zipParseTest.class.getClassLoader();

    @Test
    void pdfTest() throws Exception {

        InputStream stream = cl.getResourceAsStream("unzip/test-pdf.pdf");
        assert stream != null;
        PDF pdf = new PDF(stream);
        assertThat(pdf.text).contains("Hello World");
    }
}
