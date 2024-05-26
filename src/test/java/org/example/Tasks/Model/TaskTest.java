package org.example.Tasks.Model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {

    @Test
    public void shouldGetIsDueToday() {
        String id = "1";
        String description = "Some description";
        LocalDate dueDate = LocalDate.now();
        Task task = new Task(id, description, dueDate);

        boolean isDueToday = task.isDueToday();

        assertThat(isDueToday).isTrue();
    }

}