package com.incamp.todoweb;

import org.springframework.data.repository.CrudRepository;

public interface TaskListRepository extends CrudRepository<TaskList, Integer> {
}
