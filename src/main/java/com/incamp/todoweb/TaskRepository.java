package com.incamp.todoweb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;


public interface TaskRepository extends CrudRepository<Task, Integer> {
    // Count every incomplete task between dates
    // TODO: put normally formatted request into orm.xml
    @Query("select count(task) from Task task where task.done=false and task.dueTime between :date1 and :date2")
    Integer countIncompleteTasksBetweenDate(
            @Param("date1") LocalDateTime date1,
            @Param("date2") LocalDateTime date2);
}
