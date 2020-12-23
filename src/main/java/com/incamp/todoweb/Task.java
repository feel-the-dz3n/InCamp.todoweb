package com.incamp.todoweb;

import java.time.LocalTime;

public class Task {
    private long id;
    private final String title;
    private final String description;
    private final boolean done;
    private final LocalTime dueTime;

    public Task(long id, String title, String description, boolean done, LocalTime dueTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.dueTime = dueTime;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public LocalTime getDueTime() {
        return dueTime;
    }

    public void setId(long id) {
        this.id = id;
    }
}
