package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskListService {
    @Autowired
    private TaskListRepository taskListRepository;

    @Autowired
    private TaskService taskService;

    public Optional<TaskList> getTaskList(Integer id) {
        return taskListRepository.findById(id);
    }

    public Collection<Task> getTaskListTasksFiltered(Integer id, boolean all) {
        var tasks = getTaskListTasks(id);

        if (!all) {
            // If not all, then return only not completed tasks
            return tasks
                    .stream()
                    .filter(x -> !x.isDone())
                    .collect(Collectors.toList());
        } else {
            // Return all tasks
            return tasks;
        }
    }

    public Collection<Task> getTaskListTasks(Integer id) {
        return getTaskListTasks(getTaskList(id).get());
    }

    public Collection<Task> getTaskListTasks(TaskList taskList) {
        return taskService.getTasksByTaskList(taskList);
    }
}
