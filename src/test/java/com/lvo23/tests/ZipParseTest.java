package com.lvo23.tests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.File;
import java.io.FileReader;
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

    private static final String FILE_PATH = "src/test/resources/unzip/";

    @Test
    void pdfTest() throws Exception {

        PDF pdf = new PDF(new File(FILE_PATH + "test-pdf.pdf"));
        assertThat(pdf.text).contains("Hello World");
        // }
    }

    @Test
    void xlsxTest() {

        XLS xls = new XLS(new File(FILE_PATH + "test-xslx.xlsx"));
        assertThat(
                xls.excel.getSheet("Drivers and Teams").getRow(1).getCell(0).getStringCellValue())
                        .isEqualTo("Red Bull Racing");
    }

    @Test
    void csvTest() throws Exception {

        CSVReader reader = new CSVReader(new FileReader(FILE_PATH + "test-csv.csv"));
        List<String[]> content = reader.readAll();
        String[] row = content.get(1);
        assertThat(row[1]).contains("Max Verstappen");

    }
}
