package com.kshitiz.taskforge.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Task {
    private final UUID id;
    private final String title;
    private final String description;
    private final UUID createdBy;
    private final LocalDateTime createdOn;
    private final UUID projectId;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Priority priority;
    private final TaskStatus status;
    private final boolean isActive;
    private final LocalDateTime lastUpdatedOn;
    private final List<String> tags;  // Optional tags for categorization

    public Task(UUID id, String title, String description, UUID createdBy,
                LocalDateTime createdOn, UUID projectId, LocalDate startDate,
                LocalDate endDate, Priority priority, TaskStatus status,
                boolean isActive, LocalDateTime lastUpdatedOn, List<String> tags) {

        this.id = id != null ? id : UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.createdOn = createdOn != null ? createdOn : LocalDateTime.now();
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.status = status;
        this.isActive = isActive;
        this.lastUpdatedOn = lastUpdatedOn != null ? lastUpdatedOn : LocalDateTime.now();
        this.tags = tags;
    }

    public static Task create(String title, String description, UUID createdBy,
                              UUID projectId, LocalDate startDate, LocalDate endDate,
                              Priority priority, List<String> tags) {

        return new Task(
            UUID.randomUUID(),
            title,
            description,
            createdBy,
            LocalDateTime.now(),
            projectId,
            startDate,
            endDate,
            priority,
            TaskStatus.TO_DO,
            true,                      // isActive
            LocalDateTime.now(),
            tags
        );
    }

    // Getters for all fields

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public UUID getCreatedBy() { return createdBy; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    public UUID getProjectId() { return projectId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Priority getPriority() { return priority; }
    public TaskStatus getStatus() { return status; }
    public boolean isActive() { return isActive; }
    public LocalDateTime getLastUpdatedOn() { return lastUpdatedOn; }
    public List<String> getTags() { return tags; }

    // Add any domain-specific behavior methods here

}
