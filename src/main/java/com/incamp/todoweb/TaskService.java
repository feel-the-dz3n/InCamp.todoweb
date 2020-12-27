package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Integer id, Task newTask) {
        newTask.setId(id);
        return taskRepository.save(newTask);
    }
}
