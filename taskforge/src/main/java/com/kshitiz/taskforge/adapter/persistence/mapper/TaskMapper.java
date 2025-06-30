package com.kshitiz.taskforge.adapter.persistence.mapper;
import com.kshitiz.taskforge.adapter.persistence.entity.TaskEntity;
import com.kshitiz.taskforge.domain.model.Task;

public interface TaskMapper {
    TaskEntity toEntity(Task task);
    Task toDomain(TaskEntity entity);
}