package com.incamp.todoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TaskCollectionService {
    @Autowired
    private TaskRepository taskRepository;

    public Collection<Task> getIncompleteTasksForDate(LocalDate date) {
        return getIncompleteTasksBetweenDateTime(
                date.atStartOfDay(),
                date.atTime(LocalTime.MAX));
    }

    public Collection<Task> getIncompleteTasksUntilDate(LocalDate date) {
        return getIncompleteTasksBetweenDateTime(
                // quick workaround: LocalDateTime.MIN won't work with current SQL request
                // this code exists since 2020 hence we will count tasks since 2005
                LocalDateTime.of(2005, 01, 01, 01, 01),
                date.atTime(LocalTime.MAX));
    }

    public Collection<Task> getIncompleteTasksBetweenDateTime(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        return taskRepository.getIncompleteTasksBetweenDateTime(fromDateTime, toDateTime);
    }
}
