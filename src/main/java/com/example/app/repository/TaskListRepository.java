package com.example.app.repository;

import com.example.app.model.TaskList;
import org.springframework.data.repository.CrudRepository;

public interface TaskListRepository extends CrudRepository<TaskList, Long> {
}
