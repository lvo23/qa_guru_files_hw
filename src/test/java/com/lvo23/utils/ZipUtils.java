package com.lvo23.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author Vlad Litvinov
 * вспомогательный класс для действий с zip-файлами
 * почти всё нагло взято тут https://www.baeldung.com/java-compress-and-uncompress
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

    public static void unzip() throws Exception {
        final String fileZip = FILE_PATH + "multiCompressed.zip";
        final File destDir = new File("src/test/resources/unzip");
        final byte[] buffer = new byte[1024];
        final ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            final File newFile = newFile(destDir, zipEntry);
            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }

                final FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

    /**
     * @see https://snyk.io/research/zip-slip-vulnerability и
     * https://www.baeldung.com/java-compress-and-uncompress
     */
    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

}
