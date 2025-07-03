package com.kshitiz.taskforge.application.usecase.TaskServices;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.CreateTaskCommand;
import com.kshitiz.taskforge.domain.model.Task;
import com.kshitiz.taskforge.domain.port.TaskRepository;

@Service
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepository taskRepository;

    public CreateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskCommand command) {
        Task task = Task.create(
            command.getTitle(),
            command.getDescription(),
            command.getCreatedBy(),
            command.getProjectId(),
            command.getStartDate(),
            command.getEndDate(),
            command.getPriority(),
            command.getTags()
        );
        return taskRepository.save(task);
    }
}
