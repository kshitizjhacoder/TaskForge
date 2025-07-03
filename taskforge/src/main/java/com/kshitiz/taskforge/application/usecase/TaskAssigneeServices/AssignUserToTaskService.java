package com.kshitiz.taskforge.application.usecase.TaskAssigneeServices;
import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.TaskAssigneeDTO;
import com.kshitiz.taskforge.domain.model.TaskAssignee;
import com.kshitiz.taskforge.domain.port.TaskAssigneeRepository;

@Service
public class AssignUserToTaskService {

    private final TaskAssigneeRepository repository;

    public AssignUserToTaskService(TaskAssigneeRepository repository) {
        this.repository = repository;
    }

    public TaskAssigneeDTO assign(TaskAssigneeDTO dto) {
        TaskAssignee assignee = repository.save(dto.taskId(), dto.userId());
        return new TaskAssigneeDTO(assignee.getTaskId(), assignee.getUserId());
    }
}
