package org.example.richDomainObjects.Tasks.Model;

import lombok.Getter;
import org.example.richDomainObjects.Tasks.SortOrder;
import org.example.richDomainObjects.Tasks.TaskComparators;

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

    public List<Task> getTasksDueToday() {
        return tasks.stream().filter(it -> it.isDueToday()).toList();
    }

    public List<Task> sortTasks(SortOrder sortOrder) {
        List<Task> sortedTaskList = new ArrayList<>(tasks);
        Comparator comparator = getComparator(sortOrder);
        sortedTaskList.sort(comparator);
        return sortedTaskList;
    }

    private Comparator getComparator(SortOrder sortOrder) {
        return sortOrder == SortOrder.CREATED_DATE
                ? new TaskComparators.DueDateComparator() : new TaskComparators.CreatedDateComparator();
    }
}
