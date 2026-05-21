package com.matthieu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String title;
    private boolean done;
    private LocalDateTime createdAt;

    public Task(String title) {
        this.title = title;
        this.done = false;
        this.createdAt = LocalDateTime.now();
    }

    public String getTitle() { return title; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
    public String getCreatedAt() {
        return createdAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
