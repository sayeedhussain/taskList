package org.example.anemicDomainObjects.Tasks;

import org.example.anemicDomainObjects.Tasks.Model.Task;

import java.util.Comparator;

public class TaskComparators {

    public static class DueDateComparator implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            return task1.getDueDate().compareTo(task2.getDueDate());
        }
    }

    public static class CreatedDateComparator implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            return task1.getCreatedDate().compareTo(task2.getCreatedDate());
        }
    }
}