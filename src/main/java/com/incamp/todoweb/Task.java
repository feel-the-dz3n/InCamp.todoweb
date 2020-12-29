package com.incamp.todoweb;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String title;

    private String description;

    private boolean done;
    private LocalDateTime dueTime;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private TaskList taskList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDateTime getDueTime() {
        return dueTime;
    }

    public void setDueTime(LocalDateTime dueTime) {
        this.dueTime = dueTime;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}
