package com.example.app.repository;


import com.example.app.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Task t SET t.complete = :isComplete WHERE t.id = :id")
    void updateTaskStatus(@Param("id") long id, @Param("isComplete") boolean isComplete);
}
