package com.incamp.todoweb;

import java.util.Collection;

public class Dashboard {
    private Integer todayTasksLeft;
    private Collection<TaskListInfoDTO> taskLists;

    public Integer getTodayTasksLeft() {
        return todayTasksLeft;
    }

    public void setTodayTasksLeft(Integer todayTasksLeft) {
        this.todayTasksLeft = todayTasksLeft;
    }

    public Collection<TaskListInfoDTO> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(Collection<TaskListInfoDTO> taskLists) {
        this.taskLists = taskLists;
    }
}
