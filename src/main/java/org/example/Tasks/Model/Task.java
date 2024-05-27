package org.example.Tasks.Model;

import org.example.utils.DateUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Task {
    private final String id;
    private final String description;
    private final Date dueDate;
    private Date createdDate;

    public Task(String id, String description, Date dueDate) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.createdDate = Date.from(Instant.now());
    }

    public boolean isDueToday() {
        return DateUtils.isToday(this.dueDate);
    }

}
