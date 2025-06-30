package com.kshitiz.taskforge.adapter.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tbl_Task_Comment")
public class TaskCommentEntity {

    @Id
    @Column(name = "comment_id", nullable = false)
    private UUID id;

    @Column(name = "task_id", nullable = false)
    private UUID taskId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "commented_on", nullable = false)
    private LocalDateTime commentedOn;

    // Constructors

    public TaskCommentEntity() {
        // JPA requires a default constructor
    }

    public TaskCommentEntity(UUID id, UUID taskId, UUID userId, String content, LocalDateTime commentedOn) {
        this.id = id != null ? id : UUID.randomUUID();
        this.taskId = taskId;
        this.userId = userId;
        this.content = content;
        this.commentedOn = commentedOn != null ? commentedOn : LocalDateTime.now();
    }

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCommentedOn() {
        return commentedOn;
    }

    public void setCommentedOn(LocalDateTime commentedOn) {
        this.commentedOn = commentedOn;
    }
}
