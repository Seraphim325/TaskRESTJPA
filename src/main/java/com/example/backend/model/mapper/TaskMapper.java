package com.example.backend.model.mapper;

import com.example.backend.model.dto.TaskRequest;
import com.example.backend.model.dto.TaskResponse;
import com.example.backend.model.entity.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskMapper {

    public Task taskRequestToTask(TaskRequest taskCreateRequest) {
        Task task = new Task();
        task.setTitle(taskCreateRequest.getTitle());
        task.setDescription(taskCreateRequest.getDescription());
        task.setCompleted(taskCreateRequest.getCompleted());
        return task;
    }

    public Task taskRequestToTask(int id, TaskRequest taskCreateRequest) {
        Task task = taskRequestToTask(taskCreateRequest);
        task.setId(id);
        return task;
    }

    public TaskResponse taskToTaskResponse(Task task) {
        return new TaskResponse(
                task.getTitle(),
                task.getDescription(),
                task.getCompleted(),
                task.getCreatedAt()
        );
    }
}
