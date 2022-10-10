package com.lvo23.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvo23.pojo.TeamPojo;
import com.opencsv.CSVReader;

/**
 * @author Vlad Litvinov
 */
public class ReadFilesUtils {

    private static final String FILE_PATH = "src/test/resources/unzip/";

    public static TeamPojo readJsonFromResources() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File("src/test/resources/json-test.json"),
                    TeamPojo.class);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PDF readPDFFromResources() {

        try {
            return new PDF(new File(FILE_PATH + "test-pdf.pdf"));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static XLS readXLSFromResources() {

        try {
            return new XLS(new File(FILE_PATH + "test-xslx.xlsx"));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static List<String[]> readCSVFromResources() {

        try {
            CSVReader reader = new CSVReader(new FileReader(FILE_PATH + "test-csv.csv"));
            return reader.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
