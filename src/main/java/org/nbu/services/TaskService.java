package org.nbu.services;

import java.util.List;

import org.nbu.entities.Task;
import org.nbu.entities.User;
import org.nbu.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User user) {

        return taskRepository.findByUser(user);
    }

}
