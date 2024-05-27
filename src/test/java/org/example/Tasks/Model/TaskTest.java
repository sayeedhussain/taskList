package org.example.Tasks.Model;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {

    @Test
    public void shouldGetIsDueToday() {
        String id = "1";
        String description = "Some description";
        Date dueDate = Date.from(Instant.now());
        Task task = new Task(id, description, dueDate);

        boolean isDueToday = task.isDueToday();

        assertThat(isDueToday).isTrue();
    }

}