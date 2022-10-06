package com.lvo23.tests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.lvo23.BaseTest;
import com.opencsv.CSVReader;

/**
 * @author Vlad Litvinov
 */
public class ZipParseTest extends BaseTest {

    ClassLoader cl = ZipParseTest.class.getClassLoader();

    @Test
    void pdfTest() throws Exception {

        try (InputStream stream = cl.getResourceAsStream("unzip/test-pdf.pdf")) {
            assert stream != null;
            PDF pdf = new PDF(stream);
            assertThat(pdf.text).contains("Hello World");
        }
        ;
    }

    @Test
    void xlsxTest() throws Exception {

        try (InputStream stream = cl.getResourceAsStream("unzip/test-xslx.xlsx")) {
            assert stream != null;
            XLS xls = new XLS(stream);
            assertThat(xls.excel.getSheet("Drivers and Teams").getRow(1).getCell(0)
                    .getStringCellValue()).isEqualTo("Red Bull Racing");
        }
    }

    @Test
    void csvTest() throws Exception {

        try (InputStream stream = cl.getResourceAsStream("unzip/test-csv.csv");
                CSVReader reader = new CSVReader(new InputStreamReader(stream))) {
            List<String[]> content = reader.readAll();
            String[] row = content.get(1);
            assertThat(row[1]).contains("Red Bull Racing");

        }
    }
}
