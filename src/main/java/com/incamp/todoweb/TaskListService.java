package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TaskListService {
    @Autowired
    private TaskListRepository taskListRepository;

    @Autowired
    private TaskService taskService;

    public Optional<TaskList> getTaskList(Integer id) {
        return taskListRepository.findById(id);
    }

    public Collection<Task> getTaskListTasks(Integer id, boolean all) {
        return getTaskListTasks(getTaskList(id).get(), all);
    }

    public Collection<Task> getTaskListTasks(TaskList taskList, boolean all) {
        return taskService.getTasksByTaskList(taskList);
    }
}
