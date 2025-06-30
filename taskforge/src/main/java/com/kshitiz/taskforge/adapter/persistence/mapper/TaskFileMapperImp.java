package com.kshitiz.taskforge.adapter.persistence.mapper;

import org.springframework.stereotype.Component;

import com.kshitiz.taskforge.adapter.persistence.entity.TaskFileEntity;
import com.kshitiz.taskforge.domain.model.TaskFile;

@Component
public class TaskFileMapperImp implements TaskFileMapper{
    @Override
    public TaskFile toEntity(TaskFileEntity taskFileEntity){
        return new TaskFile(
            taskFileEntity.getFileId(),
            taskFileEntity.getTaskId()
        );
    }
    @Override
    public TaskFileEntity toDomain(TaskFile taskFile){
        return new TaskFileEntity(
            taskFile.getFileId(),
            taskFile.getTaskId()
        );
    }
}
