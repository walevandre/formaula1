package com.ua.foxminded.formula1.controller;

import com.ua.foxminded.formula1.controller.reader.FileReader;
import com.ua.foxminded.formula1.model.Racer;

import java.io.IOException;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class FilesRaceDataLoader implements RaceDataLoader {

    private static final String ABBREVIATIONS_URL = "txt/abbreviations.txt";
    private static final String START_LOG_URL = "txt/start.log";
    private static final String END_LOG_URL = "txt/end.log";
    private static final int ABBREVIATION = 0;
    private static final int RACER_NAME = 1;
    private static final int RACER_TEAM = 2;
    private static final int TIME_POINT = 1;

    private FileReader fileReader = new FileReader();
    private DataParser dataParser = new DataParser();

    @Override
    public List<Racer> loadRacers() throws IOException {

        HashMap<String, Racer> mapRacers = new HashMap<>();
        List<String> streamAbbreviations = fileReader.readFile(ABBREVIATIONS_URL);
        List<String> streamStartLog = fileReader.readFile(START_LOG_URL);
        List<String> streamEndLog = fileReader.readFile(END_LOG_URL);

        streamAbbreviations.forEach(value -> {
            List<String> arrayList = dataParser.parseAbbreviationsTxt(value);
            mapRacers.putIfAbsent(arrayList.get(ABBREVIATION), new Racer().name(arrayList.get(RACER_NAME)).team(arrayList.get(RACER_TEAM)));
        });
        streamStartLog.forEach(value -> {
            List<String> arrayList = dataParser.parseStartLog(value);
            mapRacers.get(arrayList.get(ABBREVIATION)).timeStart(LocalDateTime.parse(arrayList.get(TIME_POINT)));
        });
        streamEndLog.forEach(value -> {
            List<String> arrayList = dataParser.parseEndLog(value);
            mapRacers.get(arrayList.get(ABBREVIATION)).timeFinish(LocalDateTime.parse(arrayList.get(TIME_POINT)));
        });

        mapRacers.forEach((key, value) -> value.lapTime(computeDuration(value.timeStart(), value.timeFinish())));

        return mapRacers
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    private Duration computeDuration(LocalDateTime timeStart, LocalDateTime timeEnd) {
        return Duration.between(timeStart, timeEnd);
    }
}
