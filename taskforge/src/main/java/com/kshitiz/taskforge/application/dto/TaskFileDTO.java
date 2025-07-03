package com.kshitiz.taskforge.application.dto;

import java.util.UUID;

public record TaskFileDTO(
    UUID taskId,
    UUID fileId
) {}
