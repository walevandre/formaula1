package com.ua.foxminded.formula1;

import com.ua.foxminded.formula1.controller.FilesRaceDataLoader;
import com.ua.foxminded.formula1.model.Racer;
import com.ua.foxminded.formula1.view.FormatterResultToView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterResultToViewTest {
    private static final String NEW_LINE = "\n";


    FilesRaceDataLoader qualificationReport = Mockito.mock(FilesRaceDataLoader.class);

    @Test
    void testFormatResult() throws IOException {
        FormatterResultToView formatterResultToView = new FormatterResultToView();
        Duration duration;

        List<Racer> racerList = new ArrayList<>();

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:02:58.917"), LocalDateTime.parse("2018-05-24T12:04:03.332"));
        racerList.add(new Racer()
                .name("Sebastian Vettel")
                .team("FERRARI")
                .timeStart(LocalDateTime.parse("2018-05-24T12:02:58.917"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:04:03.332"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:02:49.914"), LocalDateTime.parse("2018-05-24T12:04:02.979"));
        racerList.add(new Racer()
                .name("Nico Hulkenberg")
                .team("RENAULT")
                .timeStart(LocalDateTime.parse("2018-05-24T12:02:49.914"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:04:02.979"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:13:04.512"), LocalDateTime.parse("2018-05-24T12:14:17.169"));
        racerList.add(new Racer()
                .name("Fernando Alonso")
                .team("MCLAREN RENAULT")
                .timeStart(LocalDateTime.parse("2018-05-24T12:13:04.512"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:14:17.169"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:03:01.250"), LocalDateTime.parse("2018-05-24T12:04:13.889"));
        racerList.add(new Racer()
                .name("Kimi Raikkonen")
                .team("FERRARI")
                .timeStart(LocalDateTime.parse("2018-05-24T12:03:01.250"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:04:13.889"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:18:37.735"), LocalDateTime.parse("2018-05-24T12:19:50.198"));
        racerList.add(new Racer()
                .name("Stoffel Vandoorne")
                .team("MCLAREN RENAULT")
                .timeStart(LocalDateTime.parse("2018-05-24T12:18:37.735"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:19:50.198"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:04:45.513"), LocalDateTime.parse("2018-05-24T12:05:58.778"));
        racerList.add(new Racer()
                .name("Marcus Ericsson")
                .team("SAUBER FERRARI")
                .timeStart(LocalDateTime.parse("2018-05-24T12:04:45.513"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:05:58.778"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:06:13.511"), LocalDateTime.parse("2018-05-24T12:07:26.834"));
        racerList.add(new Racer()
                .name("Lance Stroll")
                .team("WILLIAMS MERCEDES")
                .timeStart(LocalDateTime.parse("2018-05-24T12:06:13.511"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:07:26.834"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:14:51.985"), LocalDateTime.parse("2018-05-24T12:16:05.164"));
        racerList.add(new Racer()
                .name("Brendon Hartley")
                .team("SCUDERIA TORO ROSSO HONDA")
                .timeStart(LocalDateTime.parse("2018-05-24T12:14:51.985"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:16:05.164"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:17:58.810"), LocalDateTime.parse("2018-05-24T12:19:11.838"));
        racerList.add(new Racer()
                .name("Esteban Ocon")
                .team("FORCE INDIA MERCEDES")
                .timeStart(LocalDateTime.parse("2018-05-24T12:17:58.810"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:19:11.838"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:05:14.511"), LocalDateTime.parse("2018-05-24T12:06:27.441"));
        racerList.add(new Racer()
                .name("Romain Grosjean")
                .team("HAAS FERRARI")
                .timeStart(LocalDateTime.parse("2018-05-24T12:05:14.511"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:06:27.441"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:16:11.648"), LocalDateTime.parse("2018-05-24T12:17:24.354"));
        racerList.add(new Racer()
                .name("Sergey Sirotkin")
                .team("WILLIAMS MERCEDES")
                .timeStart(LocalDateTime.parse("2018-05-24T12:16:11.648"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:17:24.354"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:02:51.003"), LocalDateTime.parse("2018-05-24T12:04:04.396"));
        racerList.add(new Racer()
                .name("Kevin Magnussen")
                .team("HAAS FERRARI")
                .timeStart(LocalDateTime.parse("2018-05-24T12:02:51.003"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:04:04.396"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:07:23.645"), LocalDateTime.parse("2018-05-24T12:08:36.586"));
        racerList.add(new Racer()
                .name("Pierre Gasly")
                .team("SCUDERIA TORO ROSSO HONDA")
                .timeStart(LocalDateTime.parse("2018-05-24T12:07:23.645"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:08:36.586"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:03:15.145"), LocalDateTime.parse("2018-05-24T12:04:28.095"));
        racerList.add(new Racer()
                .name("Carlos Sainz")
                .team("RENAULT")
                .timeStart(LocalDateTime.parse("2018-05-24T12:03:15.145"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:04:28.095"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:12:01.035"), LocalDateTime.parse("2018-05-24T12:13:13.883"));
        racerList.add(new Racer()
                .name("Sergio Perez")
                .team("FORCE INDIA MERCEDES")
                .timeStart(LocalDateTime.parse("2018-05-24T12:12:01.035"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:13:13.883"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:14:12.054"), LocalDateTime.parse("2018-05-24T12:15:24.067"));
        racerList.add(new Racer()
                .name("Daniel Ricciardo")
                .team("RED BULL RACING TAG HEUER")
                .timeStart(LocalDateTime.parse("2018-05-24T12:14:12.054"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:15:24.067"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:18:20.125"), LocalDateTime.parse("2018-05-24T12:19:32.585"));
        racerList.add(new Racer()
                .name("Lewis Hamilton")
                .team("MERCEDES")
                .timeStart(LocalDateTime.parse("2018-05-24T12:18:20.125"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:19:32.585"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:09:41.921"), LocalDateTime.parse("2018-05-24T12:10:54.750"));
        racerList.add(new Racer()
                .name("Charles Leclerc")
                .team("SAUBER FERRARI")
                .timeStart(LocalDateTime.parse("2018-05-24T12:09:41.921"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:10:54.750"))
        .lapTime(duration));

        duration = Duration.between(LocalDateTime.parse("2018-05-24T12:00:00.000"), LocalDateTime.parse("2018-05-24T12:01:12.434"));
        racerList.add(new Racer()
                .name("Valtteri Bottas")
                .team("MERCEDES")
                .timeStart(LocalDateTime.parse("2018-05-24T12:00:00.000"))
        .timeFinish(LocalDateTime.parse("2018-05-24T12:01:12.434"))
        .lapTime(duration));


        Mockito.when(qualificationReport.loadRacers()).thenReturn(racerList);
        String actual = formatterResultToView.formatResult(qualificationReport.loadRacers());
        String expected = "1  | Sebastian Vettel    | FERRARI                     | 01:04.415" + NEW_LINE +
                        "2  | Daniel Ricciardo    | RED BULL RACING TAG HEUER   | 01:12.013" + NEW_LINE +
                        "3  | Valtteri Bottas     | MERCEDES                    | 01:12.434" + NEW_LINE +
                        "4  | Lewis Hamilton      | MERCEDES                    | 01:12.460" + NEW_LINE +
                        "5  | Stoffel Vandoorne   | MCLAREN RENAULT             | 01:12.463" + NEW_LINE +
                        "6  | Kimi Raikkonen      | FERRARI                     | 01:12.639" + NEW_LINE +
                        "7  | Fernando Alonso     | MCLAREN RENAULT             | 01:12.657" + NEW_LINE +
                        "8  | Sergey Sirotkin     | WILLIAMS MERCEDES           | 01:12.706" + NEW_LINE +
                        "9  | Charles Leclerc     | SAUBER FERRARI              | 01:12.829" + NEW_LINE +
                        "10 | Sergio Perez        | FORCE INDIA MERCEDES        | 01:12.848" + NEW_LINE +
                        "11 | Romain Grosjean     | HAAS FERRARI                | 01:12.930" + NEW_LINE +
                        "12 | Pierre Gasly        | SCUDERIA TORO ROSSO HONDA   | 01:12.941" + NEW_LINE +
                        "13 | Carlos Sainz        | RENAULT                     | 01:12.950" + NEW_LINE +
                        "14 | Esteban Ocon        | FORCE INDIA MERCEDES        | 01:13.028" + NEW_LINE +
                        "15 | Nico Hulkenberg     | RENAULT                     | 01:13.065" + NEW_LINE +
                        "------------------------------------------------------------------" + NEW_LINE +
                        "16 | Brendon Hartley     | SCUDERIA TORO ROSSO HONDA   | 01:13.179" + NEW_LINE +
                        "17 | Marcus Ericsson     | SAUBER FERRARI              | 01:13.265" + NEW_LINE +
                        "18 | Lance Stroll        | WILLIAMS MERCEDES           | 01:13.323" + NEW_LINE +
                        "19 | Kevin Magnussen     | HAAS FERRARI                | 01:13.393" + NEW_LINE;

        assertEquals(expected, actual);
    }
}