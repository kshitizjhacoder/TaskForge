package com.kshitiz.taskforge.adapter.persistence.mapper;

import com.kshitiz.taskforge.adapter.persistence.entity.TaskAssigneeEntity;
import com.kshitiz.taskforge.domain.model.TaskAssignee;

public class TaskAssigneeMapperImp implements TaskAssigneeMapper {
    @Override
    public TaskAssigneeEntity toEntity(TaskAssignee taskAssignee){
        return new TaskAssigneeEntity(
            taskAssignee.getTaskId(),
            taskAssignee.getUserId()
        );
    }
    
    @Override
    public TaskAssignee toDomain(TaskAssigneeEntity taskAssigneeEntity){
        return new TaskAssignee(
            taskAssigneeEntity.getTaskId(),
            taskAssigneeEntity.getUserId()
        );
    }
}
