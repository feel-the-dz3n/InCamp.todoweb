package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskListService {
    @Autowired
    private TaskListRepository taskListRepository;
}
