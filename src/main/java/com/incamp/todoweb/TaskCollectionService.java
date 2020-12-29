package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class TaskCollectionService {
    @Autowired
    private TaskService taskService;

    public Collection<Task> getTasksForDate(LocalDateTime date) {

    }
}
