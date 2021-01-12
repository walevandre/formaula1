package com.ua.foxminded.formula1;

import com.ua.foxminded.formula1.controller.DataParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class DataParserTest {

    private DataParser dataParser = new DataParser();

    @Test
    void shouldParseStringFromAbbreviationTxt() {
        List<String> actual = dataParser.parseAbbreviationsTxt("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER");
        List<String> expected = new ArrayList<>();
        expected.add("DRR");
        expected.add("Daniel Ricciardo");
        expected.add("RED BULL RACING TAG HEUER");

        assertThat(actual, equalTo(expected));
        assertThat(actual.size(), is(expected.size()));
    }
    @Test
    void shouldParseStringFromStartLog() {
        List<String> actual = dataParser.parseStartLog("DRR2018-05-24_12:14:12.054");
        List<String> expected = new ArrayList<>();
        expected.add("DRR");
        expected.add("2018-05-24T12:14:12.054");

        assertThat(actual, equalTo(expected));
        assertThat(actual.size(), is(expected.size()));
    }
    @Test
    void shouldParseStringFromEndLog() {
        List<String> actual = dataParser.parseStartLog("DRR2018-05-24_12:15:24.067");
        List<String> expected = new ArrayList<>();
        expected.add("DRR");
        expected.add("2018-05-24T12:15:24.067");

        assertThat(actual, equalTo(expected));
        assertThat(actual.size(), is(expected.size()));
    }
}
