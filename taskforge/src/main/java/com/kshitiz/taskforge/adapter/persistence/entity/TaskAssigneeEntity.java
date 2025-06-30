package com.kshitiz.taskforge.adapter.persistence.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tbl_Task_Assignee")
@IdClass(TaskAssigneeId.class)
public class TaskAssigneeEntity {

    @Id
    @Column(name = "task_id", nullable = false)
    private UUID taskId;

    @Id
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    // --- Constructors ---

    protected TaskAssigneeEntity() {
    }

    public TaskAssigneeEntity(UUID taskId, UUID userId) {
        this.taskId = taskId;
        this.userId = userId;
    }

    // --- Getters and Setters ---

    public UUID getTaskId() { return taskId; }
    public void setTaskId(UUID taskId) { this.taskId = taskId; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
}
