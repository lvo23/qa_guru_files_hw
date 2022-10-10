package com.lvo23.tests;

import static com.lvo23.utils.ReadFilesUtils.readCSVFromResources;
import static com.lvo23.utils.ReadFilesUtils.readPDFFromResources;
import static com.lvo23.utils.ReadFilesUtils.readXLSFromResources;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.lvo23.BaseTest;

/**
 * @author Vlad Litvinov
 */
public class ZipParseTest extends BaseTest {

    @Test
    void pdfTest() {

        PDF pdf = readPDFFromResources();
        assertThat(pdf.text).contains("Hello World");
    }

    @Test
    void xlsxTest() {

        XLS xls = readXLSFromResources();
        assertThat(
                xls.excel.getSheet("Drivers and Teams").getRow(1).getCell(0).getStringCellValue())
                        .isEqualTo("Red Bull Racing");
    }

    @Test
    void csvTest() {

        List<String[]> content = readCSVFromResources();
        String[] row = content.get(1);
        assertThat(row[1]).contains("Max Verstappen");

    }
}
