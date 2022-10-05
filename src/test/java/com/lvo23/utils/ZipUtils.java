package com.lvo23.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Vlad Litvinov
 */
public class ZipUtils {

    private static final String FILE_PATH = "src/test/resources/";

    public static void createZipMultiFiles() throws Exception {
        final List<String> srcFiles = Arrays.asList(FILE_PATH + "test-csv.csv",
                FILE_PATH + "test-pdf.pdf", FILE_PATH + "test-xslx.xlsx");
        final FileOutputStream fos =
                new FileOutputStream(FILE_PATH + "multiCompressed.zip");
        final ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (final String srcFile : srcFiles) {
            final File fileToZip = new File(srcFile);
            final FileInputStream fis = new FileInputStream(fileToZip);
            final ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            final byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }

}
