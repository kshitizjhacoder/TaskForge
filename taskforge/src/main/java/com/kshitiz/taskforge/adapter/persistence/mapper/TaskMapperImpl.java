package com.kshitiz.taskforge.adapter.persistence.mapper;

import com.kshitiz.taskforge.domain.model.Task;
import com.kshitiz.taskforge.adapter.persistence.entity.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public TaskEntity toEntity(Task task){
        return new TaskEntity(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getCreatedBy(),
            task.getCreatedOn(),
            task.getProjectId(),
            task.getStartDate(),
            task.getEndDate(),
            task.getPriority(),
            task.getStatus(),
            task.isActive(),
            task.getLastUpdatedOn(),
            String.join(",", task.getTags())
        );
    }
    @Override
    public Task toDomain(TaskEntity entity) {
        return new Task(
            entity.getId(),
            entity.getTitle(),
            entity.getDescription(),
            entity.getCreatedBy(),
            entity.getCreatedOn(),
            entity.getProjectId(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.getPriority(),
            entity.getStatus(),
            entity.isActive(),
            entity.getLastUpdatedOn(),
            List.of(entity.getTags().split(","))
        );
    }
}
