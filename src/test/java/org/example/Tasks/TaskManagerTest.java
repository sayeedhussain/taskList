package org.example.Tasks;

import org.example.Tasks.Model.TaskList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskManagerTest {

    @Test
    public void shouldAddTaskList() {
        TaskList taskList = new TaskList("1", "Work");
        TaskManager taskManager = new TaskManager();

        boolean taskListAdded = taskManager.addList(taskList);

        assertThat(taskListAdded).isTrue();
    }

    @Test
    public void shouldSortTaskListsByName() {
        TaskList taskList1 = new TaskList("1", "Work");
        TaskList taskList2 = new TaskList("2", "ToDos");

        TaskManager taskManager = new TaskManager();
        taskManager.setSortOrder(SortOrder.NAME);

        taskManager.addList(taskList1);
        taskManager.addList(taskList2);

        List<TaskList> taskLists = taskManager.getSortedTaskLists();

        assertThat(taskLists.get(0).getName()).isEqualTo("ToDos");
        assertThat(taskLists.get(1).getName()).isEqualTo("Work");
    }

    @Test
    public void shouldSortTaskListsByCreatedDate() throws InterruptedException {
        TaskList taskList1 = new TaskList("1", "Work");
        Thread.sleep(1000); //to introduce difference in creation date of the 2 taskslists
        TaskList taskList2 = new TaskList("2", "ToDos");

        TaskManager taskManager = new TaskManager();
        taskManager.setSortOrder(SortOrder.CREATED_DATE);

        taskManager.addList(taskList1);
        taskManager.addList(taskList2);

        List<TaskList> taskLists = taskManager.getSortedTaskLists();

        assertThat(taskLists.get(0).getName()).isEqualTo("Work");
        assertThat(taskLists.get(1).getName()).isEqualTo("ToDos");
    }

}
