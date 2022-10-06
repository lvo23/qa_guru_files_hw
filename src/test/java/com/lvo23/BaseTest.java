package com.lvo23;

import static com.lvo23.utils.CreateFilesUtils.createTestCSVFile;
import static com.lvo23.utils.CreateFilesUtils.createTestJSONFile;
import static com.lvo23.utils.CreateFilesUtils.createTestPDFFile;
import static com.lvo23.utils.CreateFilesUtils.createTestXLSFile;
import static com.lvo23.utils.ZipUtils.createZipMultiFiles;
import static com.lvo23.utils.ZipUtils.deleteCreatedTestFiles;
import static com.lvo23.utils.ZipUtils.deleteUnzipDirectory;
import static com.lvo23.utils.ZipUtils.unzip;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author Vlad Litvinov
 */
public class BaseTest {

    @BeforeAll
    static void setUp() throws Exception {

        createTestCSVFile();
        createTestPDFFile();
        createTestXLSFile();
        createZipMultiFiles();
        createTestJSONFile();
        unzip();
    }

    @AfterAll
    static void tearDown() throws Exception {

        deleteUnzipDirectory();
        deleteCreatedTestFiles();
    }

}
