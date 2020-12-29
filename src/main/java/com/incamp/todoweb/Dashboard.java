package com.incamp.todoweb;

import java.util.Collection;

public class Dashboard {
    private Integer todayTasksLeft;
    private Collection<TaskListInfo> taskLists;

    public Integer getTodayTasksLeft() {
        return todayTasksLeft;
    }

    public void setTodayTasksLeft(Integer todayTasksLeft) {
        this.todayTasksLeft = todayTasksLeft;
    }

    public Collection<TaskListInfo> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(Collection<TaskListInfo> taskLists) {
        this.taskLists = taskLists;
    }
}
