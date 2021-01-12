package com.ua.foxminded.formula1.controller.reader;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public List<String> readFile(String sourceFile) throws IOException {
        List<String> stringList = null;
        if (this.getClass().getClassLoader().getResource(sourceFile) == null) {
            throw new IOException("No such file - " + sourceFile);
        }
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(this
                .getClass()
                .getClassLoader()
                .getResource(sourceFile).toURI()))) {

            stringList = reader.lines().collect(Collectors.toList());
            if (stringList == null || stringList.isEmpty()) {
                throw new IOException("Empty file - " + sourceFile);
            }

        } catch (URISyntaxException e) {
            throw new IOException("Invalid format URL - " + sourceFile, e);
        }
        return stringList;
    }
}
