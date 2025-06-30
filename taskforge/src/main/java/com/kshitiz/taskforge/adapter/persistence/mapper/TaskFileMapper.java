package com.kshitiz.taskforge.adapter.persistence.mapper;

import com.kshitiz.taskforge.domain.model.TaskFile;
import com.kshitiz.taskforge.adapter.persistence.entity.TaskFileEntity;

public interface TaskFileMapper {
    TaskFile toEntity(TaskFileEntity taskFileEntity);
    TaskFileEntity toDomain(TaskFile taskFile);
}
