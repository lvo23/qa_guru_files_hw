package com.lvo23.tests;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.lvo23.utils.ReadFilesUtils.readJsonFromResources;

import org.junit.jupiter.api.Test;
import com.lvo23.BaseTest;
import com.lvo23.pojo.TeamPojo;

/**
 * @author Vlad Litvinov
 */
public class JsonParseTest extends BaseTest {

    @Test
    void jsonTest() {

        TeamPojo team = readJsonFromResources();
        assertThat(team.getName()).isEqualTo("Red Bull Racing");
        assertThat(team.getDrivers()).hasSize(2);
        assertThat(team.getCountry()).isEqualTo("Austria");

    }

}
