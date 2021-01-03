package com.incamp.todoweb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TaskListRepository extends CrudRepository<TaskList, Integer> {
    @Query("select new TaskListInfo(list.id, list.name, sum(case when task.taskList=list and task.done=false then 1 else 0 end) as tasksLeftCount) from Task task right join TaskList list on task.taskList=list group by list.id")
    Collection<TaskListInfo> fetchTaskListInfo();
}
