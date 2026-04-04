package com.example.backend.controller.v1;

import com.example.backend.model.dto.TaskRequest;
import com.example.backend.model.dto.TaskResponse;
import com.example.backend.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> postEntity(@RequestBody @Valid TaskRequest task) {
        service.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getElementById(@PathVariable int id) {
        TaskResponse task = service.get(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAll() {
        List<TaskResponse> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Successfully deleted element with id " + id, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putEntity(@PathVariable int id, @RequestBody @Valid TaskRequest task) {
        service.update(id, task);
        return new ResponseEntity<>("Successfully updated element with id " + id, HttpStatus.NO_CONTENT);
    }
}
