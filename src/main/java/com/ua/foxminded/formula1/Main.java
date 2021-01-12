package com.ua.foxminded.formula1;

import com.ua.foxminded.formula1.controller.FilesRaceDataLoader;
import com.ua.foxminded.formula1.view.FormatterResultToView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FilesRaceDataLoader qualificationReport = new FilesRaceDataLoader();
        FormatterResultToView formatterResultToView = new FormatterResultToView();
        try {
            System.out.println(formatterResultToView.formatResult(qualificationReport.loadRacers()));
        } catch (IOException|IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("System error");
        }
    }
}
