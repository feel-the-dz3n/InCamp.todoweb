package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private TaskService taskService;

    public Dashboard get() {
        return null;
    }
}
