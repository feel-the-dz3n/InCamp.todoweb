package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class DashboardService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskListRepository taskListRepository;

    public Dashboard get() {
        var dashboard = new Dashboard();
        var currentDate = LocalDate.now();

        dashboard.setTodayTasksLeft(
                taskRepository.countIncompleteTasksBetweenDateTime(
                        currentDate.atStartOfDay(),
                        currentDate.atTime(LocalTime.MAX)));

        dashboard.setTaskLists(
                taskListRepository.fetchTaskListInfo());

        return dashboard;
    }
}
