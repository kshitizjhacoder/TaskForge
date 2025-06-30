package com.kshitiz.taskforge.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskComment {
    private final UUID id;
    private final UUID taskId;
    private final UUID userId;
    private final String content;
    private final LocalDateTime commentedOn;

    public TaskComment(UUID id, UUID taskId, UUID userId, String content, LocalDateTime commentedOn) {
        this.id = id != null ? id : UUID.randomUUID();
        this.taskId = taskId;
        this.userId = userId;
        this.content = content;
        this.commentedOn = commentedOn != null ? commentedOn : LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public UUID getTaskId() { return taskId; }
    public UUID getUserId() { return userId; }
    public String getContent() { return content; }
    public LocalDateTime getCommentedOn() { return commentedOn; }
}
