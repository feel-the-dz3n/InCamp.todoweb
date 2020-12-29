package com.incamp.todoweb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TaskListRepository extends CrudRepository<TaskList, Integer> {
    // @Query("select count(task) from Task task where task.done=false and task.dueTime between :date1 and :date2")
    // SELECT task_list, SUM(CASE WHEN task.task_list_id = task_list.id AND task.done = FALSE THEN 1 ELSE 0 END) as TasksLeft FROM task RIGHT JOIN task_list ON task.task_list_id = task_list.id GROUP BY task_list;
    @Query("select new TaskListInfo(list.id, list.name, sum(case when task.taskList=list and task.done=false then 1 else 0 end) as tasksLeftCount) from Task task right join TaskList list on task.taskList=list group by list.id")
    Collection<TaskListInfo> fetchTaskListInfo();
}
