package org.example.Tasks;

import org.example.Tasks.Model.TaskList;

import java.util.Comparator;

public class Comparators {

    public static class DateComparator implements Comparator<TaskList> {
        @Override
        public int compare(TaskList list1, TaskList list2) {
            return list1.getCreatedDate().compareTo(list1.getCreatedDate());
        }
    }

    public static class NameComparator implements Comparator<TaskList> {
        @Override
        public int compare(TaskList list1, TaskList list2) {
            return list1.getName().compareTo(list2.getName());
        }
    }
}