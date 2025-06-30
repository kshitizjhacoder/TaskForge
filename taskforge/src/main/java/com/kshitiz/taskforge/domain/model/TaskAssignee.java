package com.kshitiz.taskforge.domain.model;

import java.util.UUID;

public class TaskAssignee {
    private final UUID taskId;
    private final UUID userId;

    public TaskAssignee(UUID taskId, UUID userId) {
        this.taskId = taskId;
        this.userId = userId;
    }

    public UUID getTaskId() { return taskId; }
    public UUID getUserId() { return userId; }
}
