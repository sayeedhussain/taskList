package org.example.Tasks.Model;

import org.example.Tasks.SortOrder;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskListTest {

    @Test
    public void shouldAddTask() {
        TaskList taskList = new TaskList("1", "Work");
        Date dueDate = Date.from(Instant.now());
        Task task = new Task("1", "Some description", dueDate);

        boolean taskAdded = taskList.addTask(task);

        assertThat(taskAdded).isTrue();
    }

    @Test
    public void shouldGetTasksDueToday() {
        TaskList taskList = new TaskList("1", "ToDos");
        Date dueDate1 = Date.from(Instant.now());
        Task task1 = new Task("1", "Buy Groceries", dueDate1);
        Date dueDate2 = Date.from(Instant.now().plus(2, ChronoUnit.DAYS));
        Task task2 = new Task("2", "Review finances", dueDate2);
        taskList.addTask(task1);
        taskList.addTask(task2);

        List<Task> tasksDueToday = taskList.getTasksDueToday();

        assertThat(tasksDueToday.size()).isEqualTo(1);
        assertThat(tasksDueToday.get(0).getId()).isEqualTo("1");
    }

    @Test
    public void shouldSortTasksByDueDate() {
        TaskList taskList = new TaskList("1", "ToDos");
        Date dueDate1 = Date.from(Instant.now());
        Task task1 = new Task("1", "Buy Groceries", dueDate1);
        Date dueDate2 = Date.from(Instant.now().plus(2, ChronoUnit.DAYS));
        Task task2 = new Task("2", "Review finances", dueDate2);
        taskList.addTask(task1);
        taskList.addTask(task2);

        List<Task> tasksDueToday = taskList.sortTasks(SortOrder.DUE_DATE);

        assertThat(tasksDueToday.get(0).getId()).isEqualTo("1");
    }

    @Test
    public void shouldSortTasksByCreatedDate() throws InterruptedException {
        TaskList taskList = new TaskList("1", "ToDos");
        Date dueDate1 = Date.from(Instant.now());
        Task task1 = new Task("1", "Buy Groceries", dueDate1);
        Date dueDate2 = Date.from(Instant.now().plus(2, ChronoUnit.DAYS));
        Thread.sleep(1000); //to introduce delay in created date
        Task task2 = new Task("2", "Review finances", dueDate2);
        taskList.addTask(task1);
        taskList.addTask(task2);

        List<Task> tasksDueToday = taskList.sortTasks(SortOrder.CREATED_DATE);

        assertThat(tasksDueToday.get(0).getId()).isEqualTo("1");
    }

}
