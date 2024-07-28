package org.example.anemicDomainObjects.Tasks;

import org.example.anemicDomainObjects.Tasks.Model.Task;
import org.example.anemicDomainObjects.Tasks.Model.TaskList;
import org.example.anemicDomainObjects.utils.DateUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskService {

    //TODO Note all logic is in this Service class
    private TaskList taskList = new TaskList("1", "MyToDos");

    public boolean addTask(Task task) {
        return taskList.tasks.add(task);
    }

    public List<Task> getTasksDueToday() {
        return taskList.tasks.stream().filter(it -> isTaskDueToday(it)).toList();
    }

    public List<Task> sortTasks(SortOrder sortOrder) {
        List<Task> sortedTaskList = new ArrayList<>(taskList.tasks);
        Comparator comparator = getComparator(sortOrder);
        sortedTaskList.sort(comparator);
        return sortedTaskList;
    }

    private Comparator getComparator(SortOrder sortOrder) {
        return sortOrder == SortOrder.CREATED_DATE
                ? new TaskComparators.DueDateComparator() : new TaskComparators.CreatedDateComparator();
    }

    private boolean isTaskDueToday(Task task) {
        return DateUtils.isToday(task.dueDate);
    }
}
