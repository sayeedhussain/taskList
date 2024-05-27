package org.example.Tasks.Model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskList {

    private final String id;
    private final String name;
    private final List<Task> tasks;
    private Date createdDate;

    public TaskList(String id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new ArrayList();
        this.createdDate = Date.from(Instant.now());
    }
    public boolean addTask(Task task) {
        return tasks.add(task);
    }
    public List<Task> getTasksDueToday() {
        return tasks.stream().filter(it -> it.isDueToday()).toList();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getName() { return name; }
}
