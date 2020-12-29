package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/lists")
public class TaskListController {
    @Autowired
    private TaskListService taskListService;

    @GetMapping("/{id}/tasks")
    public Iterable<Task> getListTasks(@PathVariable Integer id, boolean all) {
        return taskListService.getTaskListTasksFiltered(id, all);
    }
}
