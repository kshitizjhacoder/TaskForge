package com.kshitiz.taskforge.adapter.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.kshitiz.taskforge.domain.model.Priority;
import com.kshitiz.taskforge.domain.model.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tbl_Task")
public class TaskEntity {

    @Id
    @Column(name = "taskId", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "createdBy", nullable = false)
    private UUID createdBy;

    @Column(name = "createdOn", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "projectId")
    private UUID projectId;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "lastUpdatedOn")
    private LocalDateTime lastUpdatedOn;

    @Column(name = "tags")
    private String tags; // comma-separated tags like "urgent,backend"

    // --- Constructors ---

    protected TaskEntity() {
        // JPA default constructor
    }

    public TaskEntity(UUID id, String title, String description, UUID createdBy,
                      LocalDateTime createdOn, UUID projectId, LocalDate startDate,
                      LocalDate endDate, Priority priority, TaskStatus status,
                      boolean isActive, LocalDateTime lastUpdatedOn, String tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.status = status;
        this.isActive = isActive;
        this.lastUpdatedOn = lastUpdatedOn;
        this.tags = tags;
    }

    // --- Getters and Setters ---

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public UUID getCreatedBy() { return createdBy; }
    public void setCreatedBy(UUID createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getCreatedOn() { return createdOn; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }

    public UUID getProjectId() { return projectId; }
    public void setProjectId(UUID projectId) { this.projectId = projectId; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public LocalDateTime getLastUpdatedOn() { return lastUpdatedOn; }
    public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) { this.lastUpdatedOn = lastUpdatedOn; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }
}
