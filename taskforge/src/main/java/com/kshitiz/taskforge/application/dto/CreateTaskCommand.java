package com.kshitiz.taskforge.application.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.kshitiz.taskforge.domain.model.Priority;

public class CreateTaskCommand {
    private final String title;
    private final String description;
    private final UUID createdBy;
    private final UUID projectId;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Priority priority;
    private final List<String> tags;

    public CreateTaskCommand(String title, String description, UUID createdBy,
                             UUID projectId, LocalDate startDate, LocalDate endDate,
                             Priority priority, List<String> tags) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.tags = tags;
    }

    // Getters only (Immutable DTO)
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public UUID getCreatedBy() { return createdBy; }
    public UUID getProjectId() { return projectId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Priority getPriority() { return priority; }
    public List<String> getTags() { return tags; }
}
