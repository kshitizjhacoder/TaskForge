package com.kshitiz.taskforge.application.usecase.TaskServices;

import com.kshitiz.taskforge.application.dto.CreateTaskCommand;
import com.kshitiz.taskforge.domain.model.Task;

public interface CreateTaskUseCase {
    Task createTask(CreateTaskCommand command);
}
