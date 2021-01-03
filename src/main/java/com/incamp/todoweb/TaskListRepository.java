package com.incamp.todoweb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TaskListRepository extends CrudRepository<TaskList, Integer> {
    @Query(value = "SELECT " +
            "  tl.id, " +
            "  tl.name, " +
            "  SUM(CASE WHEN t.task_list_id=tl.id and t.done=false then 1 else 0 end) as tasksLeftCount " +
            "FROM task t " +
            "RIGHT JOIN task_list tl " +
            "  ON t.task_list_id=tl.id " +
            "GROUP " +
            "  BY tl.id;", nativeQuery = true)
    Collection<TaskListInfoDTO> fetchTaskListInfo();
}
