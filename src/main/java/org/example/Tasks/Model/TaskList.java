package org.example.Tasks.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private final String id;
    private final String name;
    private final List<Task> tasks;
    private LocalDate createdDate;

    public TaskList(String id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new ArrayList();
        this.createdDate = LocalDate.now();
    }
    public boolean addTask(String id, String description, LocalDate dueDate) {
        Task task = new Task(id, description, dueDate);
        return tasks.add(task);
    }
    public List<Task> getTasksDueToday() {
        return tasks.stream().filter(it -> it.isDueToday()).toList();
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
}
