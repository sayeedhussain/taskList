package org.example.Tasks;

import org.example.Tasks.Model.TaskList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskService {
    private final List<TaskList> taskLists;
    private SortOrder sortOrder = SortOrder.CREATED_DATE;

    public TaskService() {
         this.taskLists = new ArrayList();
    }

    public Boolean addList(TaskList taskList) {
        return taskLists.add(taskList);
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<TaskList> getSortedTaskLists() {
        List<TaskList> newTaskLists = new ArrayList<>(taskLists);
        Comparator comparator = sortOrder == SortOrder.CREATED_DATE
                ? new Comparators.DateComparator() : new Comparators.NameComparator();
        newTaskLists.sort(comparator);
        return newTaskLists;
    }
}
