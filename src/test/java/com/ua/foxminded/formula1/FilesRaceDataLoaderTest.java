package com.ua.foxminded.formula1;

import com.ua.foxminded.formula1.controller.FilesRaceDataLoader;
import com.ua.foxminded.formula1.model.Racer;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilesRaceDataLoaderTest {

    @Test
    void testLoadRacers() throws IOException {

        FilesRaceDataLoader filesRaceDataLoader = new FilesRaceDataLoader();
        List<Racer> actualRacerList = filesRaceDataLoader.loadRacers();

        assertThat(actualRacerList, hasSize(19));
        assertThat(actualRacerList, not(IsEmptyCollection.empty()));

        Duration expected = Duration.between(actualRacerList.get(1).timeStart(), actualRacerList.get(1).timeFinish());
        assertEquals("Sebastian Vettel", actualRacerList.get(1).name());
        assertEquals("FERRARI", actualRacerList.get(1).team());
        assertEquals("2018-05-24T12:02:58.917", actualRacerList.get(1).timeStart().toString());
        assertEquals("2018-05-24T12:04:03.332", actualRacerList.get(1).timeFinish().toString());
        assertEquals(expected, actualRacerList.get(1).lapTime());
    }
}
