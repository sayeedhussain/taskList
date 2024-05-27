package org.example.Tasks;

import org.example.Tasks.Model.TaskList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private final List<TaskList> taskLists;
    private SortOrder sortOrder = SortOrder.CREATED_DATE;

    public TaskManager() {
         this.taskLists = new ArrayList();
    }

    public Boolean addList(TaskList taskList) {
        return taskLists.add(taskList);
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    //TODO Update package structure
    public List<TaskList> getSortedTaskLists() {
        List<TaskList> newTaskLists = new ArrayList<>(taskLists);
        Comparator comparator = sortOrder == SortOrder.CREATED_DATE
                ? new Comparators.DateComparator() : new Comparators.NameComparator();
        newTaskLists.sort(comparator);
        return newTaskLists;
    }
}
