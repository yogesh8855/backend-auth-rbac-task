package com.primetrade.backend.service;

import com.primetrade.backend.dto.TaskRequest;
import com.primetrade.backend.dto.TaskResponse;
import com.primetrade.backend.entity.Task;
import com.primetrade.backend.entity.User;
import com.primetrade.backend.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private User getCurrentUser() {
        return (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public TaskResponse create(TaskRequest request) {
        User user = getCurrentUser();

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus())
                .user(user)
                .build();

        return toResponse(taskRepository.save(task));
    }

    public List<TaskResponse> getMyTasks() {
        User user = getCurrentUser();
        return taskRepository.findByUserId(user.getId())
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TaskResponse update(Long id, TaskRequest request) {
        User user = getCurrentUser();

        Task task = taskRepository.findById(id)
                .filter(t -> t.getUser().getId().equals(user.getId()))
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());

        return toResponse(taskRepository.save(task));
    }

    public void delete(Long id) {
        User user = getCurrentUser();

        Task task = taskRepository.findById(id)
                .filter(t -> t.getUser().getId().equals(user.getId()))
                .orElseThrow(() -> new RuntimeException("Task not found"));

        taskRepository.delete(task);
    }

    private TaskResponse toResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
    }
}
