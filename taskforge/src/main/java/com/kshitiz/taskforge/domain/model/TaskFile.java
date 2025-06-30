package com.kshitiz.taskforge.domain.model;

import java.util.UUID;

public class TaskFile {
    private final UUID taskId;
    private final UUID fileId;

    public TaskFile(UUID taskId, UUID fileId) {
        this.taskId = taskId;
        this.fileId = fileId;
    }

    public UUID getTaskId() { return taskId; }
    public UUID getFileId() { return fileId; }
}
