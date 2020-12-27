package com.incamp.todoweb;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public Iterable<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        var task = taskService.getTaskById(id);
        return task.isPresent() ? task.get() : null;
    }

    @PostMapping
    public Task postTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
    }

    @PutMapping("/{id}")
    public Task putTask(@PathVariable Integer id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }
}
