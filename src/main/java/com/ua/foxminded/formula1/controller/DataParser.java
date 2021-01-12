package com.ua.foxminded.formula1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DataParser {

    private static final int FIRST_CHARACTER = 0;
    private static final int FOURTH_CHARACTER = 3;
    private static final String SEPARATOR_FIELDS = "_";
    private static final String REGEX_PATTERN_START_END_LOG = "^(([A-Z]{3})(19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])_([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9].[0-9]{3}$";
    private static final String REGEX_PATTERN_ABBREVIATION = "^([A-Z]{3})_([^_]+?)_([^_]+?)$";

    public List<String> parseAbbreviationsTxt(String string) {
        if (!Pattern.matches(REGEX_PATTERN_ABBREVIATION, string)) {
            throw new IllegalArgumentException("Unable to parse abbreviations");
        }
        return Arrays.stream(string.split(SEPARATOR_FIELDS)).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> parseStartLog(String string) {
        if (!Pattern.matches(REGEX_PATTERN_START_END_LOG, string)) {
            throw new IllegalArgumentException("Unable to parse start.log");
        }
        return getStrings(string);
    }

    public List<String> parseEndLog(String string) {
        if (!Pattern.matches(REGEX_PATTERN_START_END_LOG, string)) {
            throw new IllegalArgumentException("Unable to parse end.log");
        }
        return getStrings(string);
    }

    private List<String> getStrings(String string) {
        String abbreviation = string.substring(FIRST_CHARACTER, FOURTH_CHARACTER);
        String time = string.substring(FOURTH_CHARACTER).replace('_', 'T');
        List<String> stringList = new ArrayList<>();
        stringList.add(abbreviation);
        stringList.add(time);
        return stringList;
    }
}
