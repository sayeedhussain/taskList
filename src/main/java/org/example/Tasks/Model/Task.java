package org.example.Tasks.Model;

import lombok.Getter;
import org.example.utils.DateUtils;

import java.time.Instant;
import java.util.Date;

public class Task {
    // TODO Notice the private getter
    private @Getter final String id;
    private @Getter final String description;
    private @Getter Date createdDate;
    private @Getter final Date dueDate;

    public Task(String id, String description, Date dueDate) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.createdDate = Date.from(Instant.now());
    }
}
