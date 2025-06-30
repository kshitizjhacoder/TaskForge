package com.kshitiz.taskforge.adapter.persistence.mapper;

import com.kshitiz.taskforge.domain.model.TaskComment;
import com.kshitiz.taskforge.adapter.persistence.entity.TaskCommentEntity;

public interface TaskCommentMapper {
    TaskComment toDomain(TaskCommentEntity taskCommentEntity);
    TaskCommentEntity toEntity(TaskComment taskComment);
}
