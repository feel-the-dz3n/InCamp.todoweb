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
                        // quick workaround: LocalDateTime.MIN won't work with current SQL request
                        // this code exists since 2020 hence we will count tasks since 2005
                        LocalDateTime.of(2005, 01, 01, 01, 01),
                        currentDate.atTime(LocalTime.MAX)));

        dashboard.setTaskLists(
                taskListRepository.fetchTaskListInfo());

        return dashboard;
    }
}
