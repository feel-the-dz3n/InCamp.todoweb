package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class DashboardService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskListRepository taskListRepository;

    public Dashboard get() {
        var dashboard = new Dashboard();

        // Since repository can handle only DateTime,
        // we will use the beginning of the current day as the date "since"
        // and the ending of the current date as the date "until"
        var currentDate = LocalDate.now();
        var startDateTime = LocalDateTime.of(
                currentDate.getYear(),
                currentDate.getMonth(),
                currentDate.getDayOfMonth(),
                0,
                0);
        var endDateTime = LocalDateTime.of(
                currentDate.getYear(),
                currentDate.getMonth(),
                currentDate.getDayOfMonth(),
                23,
                59,
                59);

        dashboard.setTodayTasksLeft(
                taskRepository.countTasksBetweenDate(startDateTime, endDateTime));

        dashboard.setTaskLists(
                taskListRepository.fetchTaskListInfo());

        return dashboard;
    }
}
