package com.kshitiz.taskforge.application.usecase.TaskFileServices;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.TaskFileDTO;
import com.kshitiz.taskforge.domain.port.TaskFileRepository;

@Service
public class GetFilesByTaskIdService {

    private final TaskFileRepository repository;

    public GetFilesByTaskIdService(TaskFileRepository repository) {
        this.repository = repository;
    }

    public List<TaskFileDTO> getFiles(UUID taskId) {
        return repository.findByTaskId(taskId).stream()
                .map(file -> new TaskFileDTO(file.getTaskId(), file.getFileId()))
                .collect(Collectors.toList());
    }
}
