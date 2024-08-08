package org.amida.task_managment_system.task_managment.controller;

import lombok.RequiredArgsConstructor;
import org.amida.task_managment_system.task_managment.exception.ResourceNotFoundException;
import org.amida.task_managment_system.task_managment.model.Comment;
import org.amida.task_managment_system.task_managment.model.Task;
import org.amida.task_managment_system.task_managment.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(taskService.updateTask(id, taskDetails));
    }

    @GetMapping("/author/{userId}")
    public ResponseEntity<List<Task>> getAllTask(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.getTaskByAuthorId(userId));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId){
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @PostMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId){
        taskService.deleteTaskById(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long id, @RequestBody Comment comment) throws ResourceNotFoundException {
        return ResponseEntity.ok(taskService.addComment(id, comment));
    }

    @GetMapping("/{taskId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.getCommentsByTaskId(taskId));
    }

}
