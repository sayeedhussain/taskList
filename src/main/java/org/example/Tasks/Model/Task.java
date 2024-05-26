package org.example.Tasks.Model;

import java.time.LocalDate;

public class Task {
    private final String id;
    private final String description;
    private final LocalDate dueDate;
    private LocalDate createdDate;

    public Task(String id, String description, LocalDate dueDate) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.createdDate = LocalDate.now();
    }

    public boolean isDueToday() {
        return dueDate.equals(LocalDate.now());
    }

}
