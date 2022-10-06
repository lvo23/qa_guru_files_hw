package com.lvo23.tests;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

import java.io.File;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvo23.BaseTest;
import com.lvo23.pojo.TeamPojo;

/**
 * @author Vlad Litvinov
 */
public class JsonParseTest extends BaseTest {

    @Test
    void jsonTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        TeamPojo team = objectMapper.readValue(new File("src/test/resources/json-test.json"), TeamPojo.class);
        assertThat(team.getName()).isEqualTo("Red Bull Racing");
        assertThat(team.getDrivers()).hasSize(2);
        assertThat(team.getCountry()).isEqualTo("Austria");

    }

}
