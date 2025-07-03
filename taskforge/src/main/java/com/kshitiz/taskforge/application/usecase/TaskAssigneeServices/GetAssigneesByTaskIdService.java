package com.kshitiz.taskforge.application.usecase.TaskAssigneeServices;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.TaskAssigneeDTO;
import com.kshitiz.taskforge.domain.port.TaskAssigneeRepository;

@Service
public class GetAssigneesByTaskIdService {

    private final TaskAssigneeRepository repository;

    public GetAssigneesByTaskIdService(TaskAssigneeRepository repository) {
        this.repository = repository;
    }

    public List<TaskAssigneeDTO> getByTaskId(UUID taskId) {
        return repository.findByTaskId(taskId).stream()
                .map(assignee -> new TaskAssigneeDTO(assignee.getTaskId(), assignee.getUserId()))
                .collect(Collectors.toList());
    }
}