package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public Collection<Task> getTasksByTaskList(TaskList taskList) {
        return getTasks()
                .stream()
                .filter(x -> x.getTaskList() == taskList)
                .collect(Collectors.toList());
    }

    public Collection<Task> getTasks() {
        return (Collection<Task>)taskRepository.findAll();
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
