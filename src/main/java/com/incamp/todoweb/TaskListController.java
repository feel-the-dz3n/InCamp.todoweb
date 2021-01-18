package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/lists")
@CrossOrigin
public class TaskListController {
    @Autowired
    private TaskListService taskListService;

    @GetMapping("/{id}/tasks")
    public Iterable<Task> getListTasks(@PathVariable Integer id, boolean all) {
        return taskListService.getTaskListTasksFiltered(id, all);
    }
}
