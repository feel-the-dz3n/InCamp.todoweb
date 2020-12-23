package com.incamp.todoweb;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private final AtomicLong idCounter = new AtomicLong();
    private final HashSet<Task> tasks = new HashSet();

    @GetMapping("/tasks")
    public Collection<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    public Task postTask(@RequestBody Task task) {
        task.setId(idCounter.getAndIncrement());
        tasks.add(task);
        return task;
    }
}
