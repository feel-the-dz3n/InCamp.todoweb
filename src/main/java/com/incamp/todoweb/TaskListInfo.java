package com.incamp.todoweb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // FIXME
public class TaskListInfo {
    @Id
    private Integer id;
    private String name;
    private Long tasksLeftCount;

    public TaskListInfo() {
    }

    public TaskListInfo(Integer id, String name, Long tasksLeftCount) {
        this.id = id;
        this.name = name;
        this.tasksLeftCount = tasksLeftCount;
    }

    public Long getTasksLeftCount() {
        return tasksLeftCount;
    }

    public void setTasksLeftCount(Long tasksLeftCount) {
        this.tasksLeftCount = tasksLeftCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
