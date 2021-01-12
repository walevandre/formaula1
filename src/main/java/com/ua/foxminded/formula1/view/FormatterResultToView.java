package com.ua.foxminded.formula1.view;

import com.ua.foxminded.formula1.model.Racer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatterResultToView {

    private static final String NEW_LINE = "\n";
    private static final String LINE_SEPARATOR = "-";
    private static final String COLUMN_SEPARATOR = "|";
    private static final String SPACE = " ";
    private static final int INDENT = 3;
    private static final int ELIMINATION_BORDER = 15;
    private static final int LINE_BORDER = 1;
    private static final int LENGTH_COLUMN_COUNTER = 3;
    private static final int FIRST_LINE = 0;
    private static final int POSITION_OFFSET = 1;

    public String formatResult(List<Racer> racerList)  {

        if (racerList == null || racerList.isEmpty()){
            throw new IllegalArgumentException("Empty list to view in class " + this.getClass().getName());
        }

        int lengthColumnName = computeMaxLengthName(racerList) + INDENT;
        int lengthColumnTeam = computeMaxLengthTeam(racerList) + INDENT;

        StringBuilder result = new StringBuilder(racerList.size() + LINE_BORDER);

        List<Racer> qualificationReport = racerList
                .stream()
                .sorted(Comparator.comparing(value -> value.lapTime()))
                .collect(Collectors.toCollection(ArrayList::new));

        qualificationReport.stream().limit(ELIMINATION_BORDER).forEach(value -> result
                .append(prepareString(qualificationReport.indexOf(value) + POSITION_OFFSET, value, lengthColumnName, lengthColumnTeam))
                .append(NEW_LINE));
        int lengthString = result.toString().split(NEW_LINE)[FIRST_LINE].length();
        result.append(Stream.generate(() -> LINE_SEPARATOR).limit(lengthString).collect(Collectors.joining())).append(NEW_LINE);
        qualificationReport.stream().skip(ELIMINATION_BORDER).forEach(value -> result
                .append(prepareString(qualificationReport.indexOf(value) + POSITION_OFFSET, value, lengthColumnName, lengthColumnTeam))
                .append(NEW_LINE));

        return result.toString();
}

    private int computeMaxLengthName(List<Racer> listRacer) {
        return listRacer
                .stream()
                .mapToInt(value -> Integer.valueOf(value.name().length()))
                .max()
                .orElse(0);
    }

    private int computeMaxLengthTeam(List<Racer> listRacer) {
        return listRacer
                .stream()
                .mapToInt((value) -> Integer.valueOf(value.team().length()))
                .max()
                .orElse(0);
    }

    private String prepareString(int numberOfSequence, Racer racer, int lengthColumnName, int lengthColumnTeam) {
        return String.format("%-" + LENGTH_COLUMN_COUNTER + "s" + COLUMN_SEPARATOR + SPACE, numberOfSequence)
                + String.format("%-" + lengthColumnName + "s" + COLUMN_SEPARATOR + SPACE, racer.name())
                + String.format("%-" + lengthColumnTeam + "s" + COLUMN_SEPARATOR + SPACE, racer.team())
                + LocalDateTime
                .ofInstant(Instant.ofEpochMilli(racer.lapTime().toMillis()), TimeZone.getDefault().toZoneId())
                .format(DateTimeFormatter.ofPattern("mm:ss.SSS"));
    }
}
