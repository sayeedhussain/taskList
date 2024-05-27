package org.example.Tasks.Model;

import org.junit.jupiter.api.Test;

import java.time.Instant;
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
        Date dueDate = Date.from(Instant.now());
        Task task = new Task("1", "Some description", dueDate);
        taskList.addTask(task);

        List<Task> tasksDueToday = taskList.getTasksDueToday();

        assertThat(tasksDueToday.size()).isEqualTo(1);
    }
}
