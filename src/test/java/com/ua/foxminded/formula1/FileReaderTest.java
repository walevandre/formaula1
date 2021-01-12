package com.ua.foxminded.formula1;

import com.ua.foxminded.formula1.controller.reader.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileReaderTest {

    private static final String ABBREVIATIONS_URL = "txt/testRead.txt";
    private static final String DOESNT_EXIST_FILE = "txt/someFile.txt";
    private static final String EMPTY_FILE = "txt/emptyFile.txt";
    FileReader fileReader = new FileReader();

    @Test
    void shouldReturnListStringsFromFile() throws IOException {
        List<String> actual = fileReader.readFile(ABBREVIATIONS_URL);
        List<String> expected = new ArrayList<>();
        expected.add("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER");
        expected.add("SVF_Sebastian Vettel_FERRARI");
        expected.add("LHM_Lewis Hamilton_MERCEDES");

        assertThat(actual, equalTo(expected));
        assertThat(actual.size(), is(expected.size()));
    }

    @Test
    void throwsExceptionWhenFileDoesntExist() {
        Exception exception = assertThrows(IOException.class, () -> {
            List<String> actual = fileReader.readFile(DOESNT_EXIST_FILE);
        });

        String expectedMessage = "No such file - " + DOESNT_EXIST_FILE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void throwsExceptionWhenFileIsEmpty() {
        Exception exception = assertThrows(IOException.class, () -> {
            List<String> actual = fileReader.readFile(EMPTY_FILE);
        });

        String expectedMessage = "Empty file - " + EMPTY_FILE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
