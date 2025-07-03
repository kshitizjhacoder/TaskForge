package com.kshitiz.taskforge.application.usecase.TaskFileServices;
import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.TaskFileDTO;
import com.kshitiz.taskforge.domain.model.TaskFile;
import com.kshitiz.taskforge.domain.port.TaskFileRepository;

@Service
public class AttachFileToTaskService {

    private final TaskFileRepository repository;

    public AttachFileToTaskService(TaskFileRepository repository) {
        this.repository = repository;
    }

    public TaskFileDTO attach(TaskFileDTO dto) {
        TaskFile saved = repository.save(dto.taskId(), dto.fileId());
        return new TaskFileDTO(saved.getTaskId(), saved.getFileId());
    }
}   