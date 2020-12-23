package com.incamp.todoweb;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private final AtomicLong idCounter = new AtomicLong();
    private final List<Task> tasks = Arrays.asList(
            new Task(
                    idCounter.getAndIncrement(),
                    "Task 1",
                    "Task 1 Description",
                    false,
                    LocalTime.of(10, 10))
    );

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
