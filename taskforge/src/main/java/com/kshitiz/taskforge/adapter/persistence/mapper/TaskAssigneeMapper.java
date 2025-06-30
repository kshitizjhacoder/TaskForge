package com.kshitiz.taskforge.adapter.persistence.mapper;

import com.kshitiz.taskforge.domain.model.TaskAssignee;
import com.kshitiz.taskforge.adapter.persistence.entity.TaskAssigneeEntity;

public interface TaskAssigneeMapper {
    TaskAssigneeEntity toEntity(TaskAssignee taskAssignee);
    TaskAssignee toDomain(TaskAssigneeEntity taskAssigneeEntity);
}
