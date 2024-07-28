package org.example.anemicDomainObjects.Tasks.Model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskList {
    // TODO Notice the public getter and setter
    // TODO Notice no logic in this Entity class
    public final String id;
    public final String name;

    public final List<Task> tasks;
    public final Date createdDate;

    public TaskList(String id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new ArrayList();
        this.createdDate = Date.from(Instant.now());
    }
}
