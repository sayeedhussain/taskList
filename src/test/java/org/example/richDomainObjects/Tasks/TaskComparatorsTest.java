package org.example.richDomainObjects.Tasks;

import org.example.richDomainObjects.Tasks.Model.Task;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class TaskComparatorsTest {

    @Test
    void shouldCompareDueDates() {

        Date dueDate1 = Date.from(Instant.now());
        Task task1 = new Task("1", "Buy Groceries", dueDate1);
        Date dueDate2 = Date.from(Instant.now().plus(2, ChronoUnit.DAYS));
        Task task2 = new Task("2", "Review finances", dueDate2);

        int result = new TaskComparators.DueDateComparator().compare(task1, task2);

        assertThat(result).isLessThan(0);
    }

    @Test
    void shouldCompareCreatedDates() throws InterruptedException {

        Date dueDate1 = Date.from(Instant.now());
        Task task1 = new Task("1", "Buy Groceries", dueDate1);
        Date dueDate2 = Date.from(Instant.now().plus(2, ChronoUnit.DAYS));
        Thread.sleep(1000); //to introduce delay in created date
        Task task2 = new Task("2", "Review finances", dueDate2);

        int result = new TaskComparators.CreatedDateComparator().compare(task1, task2);

        assertThat(result).isLessThan(0);
    }

}