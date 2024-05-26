package org.example.Tasks.Model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskListTest {

    @Test
    public void shouldAddTask() {
        TaskList taskList = new TaskList("1", "Work");
        LocalDate dueDate = LocalDate.of(2023, Month.APRIL, 28);

        boolean taskAdded = taskList.addTask("1", "Some description", dueDate);

        assertThat(taskAdded).isTrue();
    }

    @Test
    public void shouldGetTasksDueToday() {
        TaskList taskList = new TaskList("1", "ToDos");
        taskList.addTask("1", "Some description", LocalDate.now());

        List<Task> tasksDueToday = taskList.getTasksDueToday();

        assertThat(tasksDueToday.size()).isEqualTo(1);
    }
}

/*
    Deadlines
        Give each task an optional deadline with the deadline <ID> <date> command.
        Show all tasks due today with the today command.
    Customisable IDs
        Allow the user to specify an identifier that’s not a number.
        Disallow spaces and special characters from the ID.
    Deletion
        Allow users to delete tasks with the delete <ID> command.
    Views
        View tasks by date with the view by date command.
        View tasks by deadline with the view by deadline command.
        Don’t remove the functionality that allows users to view tasks by project, but change the command to view by project.

 */