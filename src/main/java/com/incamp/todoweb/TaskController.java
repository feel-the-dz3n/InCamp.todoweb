package com.incamp.todoweb;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final AtomicLong idCounter = new AtomicLong();
    private final List<Task> tasks = Arrays.asList(); // FIXME

    @GetMapping("/tasks")
    public Object[] getTasks() {
        return tasks.toArray();
    }

    @PostMapping("/tasks")
    public Task postTask() {
        return new Task(); // FIXME
    }
}
