package com.example.taskmanagement.service;

import com.example.taskmanagement.entities.Task;
import com.example.taskmanagement.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;
    public Task getTaskById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("task not found")
        );
    }

    public Task updateTaskById(Long id, Task task) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );
    }

    public String deleteTaskById(Long id) {
        Task task = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );
        repository.delete(task);
        return "User has been deleted";
    }

    public Task addTask(Task task) {
        return repository.save(Task.builder()
                .header(task.getHeader())
                .description(task.getDescription())
                .status(task.getStatus())
                .build());
    }
}
