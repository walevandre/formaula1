package com.ua.foxminded.formula1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Duration;
import java.time.LocalDateTime;

@Accessors(fluent = true)
@Getter
@Setter
public class Racer {
    private String name;
    private String team;
    private LocalDateTime timeStart;
    private LocalDateTime timeFinish;
    private Duration lapTime;
}
