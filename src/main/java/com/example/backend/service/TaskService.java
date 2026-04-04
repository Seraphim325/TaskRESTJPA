package com.example.backend.service;


import com.example.backend.error.exception.TaskNotFoundException;
import com.example.backend.model.dto.TaskRequest;
import com.example.backend.model.dto.TaskResponse;
import com.example.backend.model.entity.Task;
import com.example.backend.model.mapper.TaskMapper;
import com.example.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    @Autowired
    public TaskService(TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void create(TaskRequest taskRequest) {
        repository.save(mapper.taskRequestToTask(taskRequest));
    }

    public TaskResponse get(int id) {
        Optional<Task> task = repository.findById(id);
        if (task.isEmpty()) throw new TaskNotFoundException("Task with id " + id + " not found");
        return mapper.taskToTaskResponse(task.get());
    }

    public List<TaskResponse> getAll() {
        return repository.findAll().stream().map(mapper::taskToTaskResponse).toList();
    }

    public void delete(int id) {
        get(id);
        repository.deleteById(id);
    }

    public void update(int id, TaskRequest taskRequest) {
        Task task = mapper.taskRequestToTask(id, taskRequest);
        task.setCreatedAt(get(id).getCreatedAt());
        repository.save(task);
    }
}
