package com.kshitiz.taskforge.domain.port;
import com.kshitiz.taskforge.domain.model.TaskFile;
import java.util.UUID;
import java.util.List;
public interface TaskFileRepository {
    TaskFile save(UUID taskId, UUID fileId);
    List<TaskFile> findByTaskId(UUID taskId);
}
