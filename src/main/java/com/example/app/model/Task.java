package com.example.app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column(name = "complete")
    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "task_list_id", nullable = false)
    private TaskList taskList;

    public Task() {}

    public Task(String name) {
        this(name, false);
    }

    public Task(String name, boolean complete) {
        this.name = name;
        this.complete = complete;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isComplete() {
        return complete;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
