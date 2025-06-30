package com.kshitiz.taskforge.domain.port;
import com.kshitiz.taskforge.domain.model.TaskAssignee;
import java.util.UUID;
import java.util.List;
public interface TaskAssigneeRepository {
    TaskAssignee save(UUID taskId, UUID userId);
    List<TaskAssignee> findByTaskId(UUID taskId);
    List<TaskAssignee> findByUserId(UUID userId);
}
