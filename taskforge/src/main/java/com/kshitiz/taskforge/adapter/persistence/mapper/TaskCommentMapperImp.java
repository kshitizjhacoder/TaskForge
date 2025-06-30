package com.kshitiz.taskforge.adapter.persistence.mapper;

import com.kshitiz.taskforge.adapter.persistence.entity.TaskCommentEntity;
import com.kshitiz.taskforge.domain.model.TaskComment;
import org.springframework.stereotype.Component;

@Component
public class TaskCommentMapperImp implements TaskCommentMapper {

    @Override
    public TaskCommentEntity toEntity(TaskComment comment) {
        return new TaskCommentEntity(
            comment.getId(),
            comment.getTaskId(),
            comment.getUserId(),
            comment.getContent(),
            comment.getCommentedOn()
        );
    }

    @Override
    public TaskComment toDomain(TaskCommentEntity entity) {
        return new TaskComment(
            entity.getId(),
            entity.getTaskId(),
            entity.getUserId(),
            entity.getContent(),
            entity.getCommentedOn()
        );
    }
}
