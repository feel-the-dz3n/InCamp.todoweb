package com.incamp.todoweb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Collection;


public interface TaskRepository extends CrudRepository<Task, Integer> {
    @Query("select count(task) from Task task " +
            "where task.done=false " +
            "and task.dueTime between :fromDateTime and :toDate")
    Integer countIncompleteTasksBetweenDateTime(
            @Param("fromDateTime") LocalDateTime fromDateTime,
            @Param("toDateTime") LocalDateTime toDateTime);

    @Query("select task from Task task " +
            "where task.taskList=:taskList " +
            "and task.done=false")
    Collection<Task> GetIncompleteTasksByTaskList(
            @Param("taskList") TaskList taskList);

    @Query("select task from Task task " +
            "where task.taskList=:taskList")
    Collection<Task> getTasksByTaskList(
            @Param("taskList") TaskList taskList);

    @Query("select task from Task task " +
            "where task.done=false " +
            "and task.dueTime between :startDateTime and :endDateTime")
    Collection<Task> getIncompleteTasksBetweenDateTime(
            @Param("fromDateTime") LocalDateTime fromDateTime,
            @Param("toDateTime") LocalDateTime toDateTime);
}
