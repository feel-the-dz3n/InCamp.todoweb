package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping(path = "/collection")
public class TaskCollectionController {
    @Autowired
    private TaskCollectionService taskCollectionService;

    @GetMapping("/today")
    public Collection<Task> getTasksForToday() {
        return taskCollectionService.getTasksForDate(LocalDateTime.now());
    }
}
