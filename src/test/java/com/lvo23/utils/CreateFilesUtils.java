package com.lvo23.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;

/**
 * @author Vlad Litvinov вспомогательный класс для создания тестовых файлов
 */
public class CreateFilesUtils {

    private static final String FILE_PATH = "src/test/resources/";

    public static void createTestCSVFile() throws Exception {

        List<String[]> content = new ArrayList<>();
        String[] headers = "number,driver,team".split(",");
        String[] data = "1,Max Verstappen,Red Bull Racing".split(",");
        content.add(headers);
        content.add(data);

        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH + "test-csv.csv"))) {
            writer.writeAll(content);
        }
    }

    public static void createTestPDFFile() {

        Document document = new Document();
        try {
            final PdfWriter instance = PdfWriter.getInstance(document,
                    new FileOutputStream(FILE_PATH + "test-pdf.pdf"));

            document.open();
            instance.getInfo().put(PdfName.CREATOR, new PdfString(Document.getVersion()));
            document.add(new Paragraph("Hello World"));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }

        document.close();
    }

    public static void createTestXLSFile() throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Drivers and Teams");

        Row header = sheet.createRow(0);
        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Team");
        headerCell = header.createCell(1);
        headerCell.setCellValue("Driver");
        headerCell = header.createCell(2);
        headerCell.setCellValue("Number");

        Row row = sheet.createRow(1);
        Cell cell = row.createCell(0);
        cell.setCellValue("Red Bull Racing");
        cell = row.createCell(1);
        cell.setCellValue("Max Verstappen");
        cell = row.createCell(2);
        cell.setCellValue("1");

        try (FileOutputStream outputStream = new FileOutputStream(FILE_PATH + "test-xslx.xlsx")) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
