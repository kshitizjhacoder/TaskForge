package com.kshitiz.taskforge.adapter.persistence.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class TaskFileId implements Serializable {

    private UUID taskId;
    private UUID fileId;

    public TaskFileId() {}

    public TaskFileId(UUID taskId, UUID fileId) {
        this.taskId = taskId;
        this.fileId = fileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskFileId that)) return false;
        return Objects.equals(taskId, that.taskId) &&
               Objects.equals(fileId, that.fileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, fileId);
    }
}
