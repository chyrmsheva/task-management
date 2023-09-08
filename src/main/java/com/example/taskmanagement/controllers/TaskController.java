package com.example.taskmanagement.controllers;

import com.example.taskmanagement.entities.Task;
import com.example.taskmanagement.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Tag(name = "Task Controller", description = "CRUD upon tasks")
public class TaskController {

    private final TaskService service;
    @Operation(description = "get task by id")
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @Operation(description = "update task by id")
    @PutMapping("/{id}")
    public Task updateTaskById(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTaskById(id, task);
    }

    @Operation(description = "delete task by id")
    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable Long id) {
        return service.deleteTaskById(id);
    }

    @Operation(description = "add task")
    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }
}
