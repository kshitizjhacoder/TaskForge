package com.kshitiz.taskforge.application.usecase.TaskCommentServices;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kshitiz.taskforge.application.dto.TaskCommentDTO;
import com.kshitiz.taskforge.domain.port.TaskCommentRepository;

@Service
public class GetCommentsByUserIdService {

    private final TaskCommentRepository taskCommentRepository;

    public GetCommentsByUserIdService(TaskCommentRepository taskCommentRepository) {
        this.taskCommentRepository = taskCommentRepository;
    }

    public List<TaskCommentDTO> getByUserId(UUID userId) {
        return taskCommentRepository.findByUserId(userId)
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