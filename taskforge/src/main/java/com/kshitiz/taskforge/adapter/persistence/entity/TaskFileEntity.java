package com.kshitiz.taskforge.adapter.persistence.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tbl_Task_File")
@IdClass(TaskFileId.class)
public class TaskFileEntity {

    @Id
    @Column(name = "task_id", nullable = false)
    private UUID taskId;

    @Id
    @Column(name = "file_id", nullable = false)
    private UUID fileId;

    // --- Constructors ---

    protected TaskFileEntity() {
    }

    public TaskFileEntity(UUID taskId, UUID fileId) {
        this.taskId = taskId;
        this.fileId = fileId;
    }

    // --- Getters and Setters ---

    public UUID getTaskId() { return taskId; }
    public void setTaskId(UUID taskId) { this.taskId = taskId; }

    public UUID getFileId() { return fileId; }
    public void setFileId(UUID fileId) { this.fileId = fileId; }
}
