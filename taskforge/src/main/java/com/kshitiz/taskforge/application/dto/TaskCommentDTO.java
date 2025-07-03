package com.kshitiz.taskforge.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskCommentDTO(
    UUID id,
    UUID taskId,
    UUID userId,
    String content,
    LocalDateTime commentedOn
) {}
