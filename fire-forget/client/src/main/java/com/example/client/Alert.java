package com.example.client;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Alert {
    public enum Level{
        YELLOW, ORANGE, RED, BLACK
    }

    private Level level;
    private String orderedBy;
    private Instant orderedAt;
}