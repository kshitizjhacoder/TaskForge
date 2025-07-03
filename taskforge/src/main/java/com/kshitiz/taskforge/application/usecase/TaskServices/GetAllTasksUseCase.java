package com.kshitiz.taskforge.application.usecase.TaskServices;
import java.util.List;

import com.kshitiz.taskforge.domain.model.Task;
import com.kshitiz.taskforge.domain.port.TaskRepository;
public class GetAllTasksUseCase {
    private final TaskRepository taskRepository;

    public GetAllTasksUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> execute() {
        return taskRepository.findAll();
    }
}
