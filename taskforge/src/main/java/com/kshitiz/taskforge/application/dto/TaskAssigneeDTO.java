package com.kshitiz.taskforge.application.dto;
import java.util.UUID;

public record TaskAssigneeDTO(
    UUID taskId,
    UUID userId
) {}