package com.kshitiz.taskforge.application.usecase.TaskAssigneeServices;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.TaskAssigneeDTO;
import com.kshitiz.taskforge.domain.port.TaskAssigneeRepository;

@Service
public class GetAssignmentsByUserIdService {

    private final TaskAssigneeRepository repository;

    public GetAssignmentsByUserIdService(TaskAssigneeRepository repository) {
        this.repository = repository;
    }

    public List<TaskAssigneeDTO> getByUserId(UUID userId) {
        return repository.findByUserId(userId).stream()
                .map(assignee -> new TaskAssigneeDTO(assignee.getTaskId(), assignee.getUserId()))
                .collect(Collectors.toList());
    }
}