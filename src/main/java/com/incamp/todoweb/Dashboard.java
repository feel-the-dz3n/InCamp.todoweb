package com.incamp.todoweb;

import java.util.Collection;

public class Dashboard {
    private Integer todayTasksCount;
    private Collection<TaskListInfo> TaskLists;

    public Integer getTodayTasksCount() {
        return todayTasksCount;
    }

    public void setTodayTasksCount(Integer todayTasksCount) {
        this.todayTasksCount = todayTasksCount;
    }

    public Collection<TaskListInfo> getTaskLists() {
        return TaskLists;
    }

    public void setTaskLists(Collection<TaskListInfo> taskLists) {
        TaskLists = taskLists;
    }
}
