package com.kshitiz.taskforge.adapter.persistence.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class TaskAssigneeId implements Serializable {

    private UUID taskId;
    private UUID userId;

    public TaskAssigneeId() {}

    public TaskAssigneeId(UUID taskId, UUID userId) {
        this.taskId = taskId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskAssigneeId that)) return false;
        return Objects.equals(taskId, that.taskId) &&
               Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, userId);
    }
}
