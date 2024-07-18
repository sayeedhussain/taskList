package org.example.Tasks.Model;

import lombok.Getter;
import org.example.Tasks.SortOrder;
import org.example.Tasks.TaskComparators;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TaskList {
    // TODO Notice the private getter
    private @Getter final String id;
    private @Getter final String name;
    private @Getter final List<Task> tasks;
    private @Getter Date createdDate;

    public TaskList(String id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new ArrayList();
        this.createdDate = Date.from(Instant.now());
    }

    public boolean addTask(Task task) {
        return tasks.add(task);
    }

}
