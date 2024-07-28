package org.example.anemicDomainObjects.Tasks.Model;

import lombok.Getter;

import java.time.Instant;
import java.util.Date;

public class Task {
    // TODO Notice the public getter and setter
    // TODO Notice no logic in this Entity class
    public final String id;
    public @Getter final String description;
    public @Getter Date createdDate;
    public @Getter final Date dueDate;

    public Task(String id, String description, Date dueDate) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.createdDate = Date.from(Instant.now());
    }

}
