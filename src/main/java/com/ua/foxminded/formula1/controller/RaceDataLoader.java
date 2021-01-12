package com.ua.foxminded.formula1.controller;

import com.ua.foxminded.formula1.model.Racer;

import java.io.IOException;
import java.util.List;

public interface RaceDataLoader {
    List<Racer> loadRacers() throws IOException;
}
