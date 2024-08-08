package org.amida.task_managment_system.task_managment.service;

import lombok.RequiredArgsConstructor;
import org.amida.task_managment_system.task_managment.exception.ResourceNotFoundException;
import org.amida.task_managment_system.task_managment.repository.CommentRepository;
import org.amida.task_managment_system.task_managment.repository.TaskRepository;
import org.amida.task_managment_system.task_managment.model.Comment;
import org.amida.task_managment_system.task_managment.model.Task;
import org.amida.task_managment_system.user_managment.model.User;
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

    public List<Task> getTaskByAuthorId(Long authorId) {
        return taskRepository.findByAuthorId(authorId);
    }

    public List<Task> findByAssigneeId(Long assigneeId) {
        return taskRepository.findByAssigneeId(assigneeId);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public void setAssigneeToTask(Task task, User userId) throws ResourceNotFoundException {

        if (task != null) {
            task.setAssignee(userId);
        }

        throw new ResourceNotFoundException("Task is null");
    }

    public Comment addComment(Long taskId, Comment comment) throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        comment.setTask(task);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByTaskId(Long taskId) {
        return commentRepository.findByTaskId(taskId);
    }

    public List<Comment> getCommentsByTaskIdAndAuthorId(Long taskId, Long authorId){
        return commentRepository.findByTaskIdAndAuthorId(taskId, authorId);
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
