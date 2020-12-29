package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TaskCollectionService {
    @Autowired
    private TaskService taskService;

    // Returns tasks that are not done yet at some date
    public Collection<Task> getTasksForDate(LocalDateTime date) {
        return taskService
                .getTasks()
                .stream()
                .filter(x -> !x.isDone()
                        && x.getDueTime() != null
                        && x.getDueTime().getYear() == date.getYear()
                        && x.getDueTime().getMonth() == date.getMonth()
                        && x.getDueTime().getDayOfMonth() == date.getDayOfMonth())
                .collect(Collectors.toList());
    }
}
