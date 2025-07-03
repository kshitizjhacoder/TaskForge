package com.kshitiz.taskforge.application.usecase.TaskCommentServices;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.TaskCommentDTO;
import com.kshitiz.taskforge.domain.port.TaskCommentRepository;

@Service
public class GetCommentsByTaskIdService {

    private final TaskCommentRepository taskCommentRepository;

    public GetCommentsByTaskIdService(TaskCommentRepository taskCommentRepository) {
        this.taskCommentRepository = taskCommentRepository;
    }

    public List<TaskCommentDTO> getByTaskId(UUID taskId) {
        return taskCommentRepository.findByTaskId(taskId)
            .stream()
            .map(comment -> new TaskCommentDTO(
                comment.getId(),
                comment.getTaskId(),
                comment.getUserId(),
                comment.getContent(),
                comment.getCommentedOn()
            ))
            .collect(Collectors.toList());
    }
}