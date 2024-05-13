package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Task;
import com.example.repository.TaskRepository;

public class TaskService {
	 @Autowired
	    private TaskRepository taskRepository;

	    public List<Task> getAllTasks() {
	        return taskRepository.findAll();
	    }

	    public Optional<Task> getTaskById(Long id) {
	        return taskRepository.findById(id);
	    }

	    public Task createTask(Task task) {
	        return taskRepository.save(task);
	    }

	    public Task updateTask(Long id, Task taskDetails) {
	        Task task = taskRepository.findById(id).orElse(null);
	        if (task != null) {
	            task.setTitle(taskDetails.getTitle());
	            task.setDescription(taskDetails.getDescription());
	            task.setDueDate(taskDetails.getDueDate());
	            return taskRepository.save(task);
	        }
	        return null;
	    }

	    public void deleteTask(Long id) {
	        taskRepository.deleteById(id);
	    }
	}


