package org.amida.task_managment_system.service;

import lombok.RequiredArgsConstructor;
import org.amida.task_managment_system.exception.ResourceNotFoundException;
import org.amida.task_managment_system.repository.CommentRepository;
import org.amida.task_managment_system.repository.TaskRepository;
import org.amida.task_managment_system.task_managment.model.Comment;
import org.amida.task_managment_system.task_managment.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    public Comment addComment(Long taskId, Comment comment) throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        comment.setTask(task);
        return commentRepository.save(comment);
    }

    public List<Comment> getComments(Long taskId) {
        return commentRepository.findByTaskId(taskId);
    }

    public Task updateTask(Long id, Task taskDetails) throws ResourceNotFoundException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setPriority(taskDetails.getPriority());
        task.setAssignee(taskDetails.getAssignee());

        return taskRepository.save(task);
    }

}
